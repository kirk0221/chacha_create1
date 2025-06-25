package com.chacha.create.service.mainhome.store;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.product.MainProductDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.common.mapper.member.SellerMapper;
import com.chacha.create.common.mapper.product.MainProductMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainProductService {

    private final MainProductMapper mainProductMapper;
    private final SellerMapper sellerMapper;

    /**
     * 로그인된 회원의 sellerId, storeId를 배열로 반환합니다.
     * 검증 실패 시 null 반환.
     * [0] = sellerId, [1] = storeId
     */
    private int[] validateSellerAndStore(HttpSession session) {
        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        if (loginMember == null) {
            log.warn("로그인된 회원 정보가 없습니다.");
            return null;
        }

        SellerEntity seller = sellerMapper.selectByMemberId(loginMember.getMemberId());
        if (seller == null) {
            log.warn("판매자 정보가 없습니다.");
            return null;
        }

        Integer storeId = mainProductMapper.selectStoreIdBySellerId(seller.getSellerId());
        if (storeId == null) {
            log.warn("스토어 정보가 없습니다.");
            return null;
        }

        return new int[] { seller.getSellerId(), storeId };
    }

    public int insertMainProductWithImages(MainProductDTO dto, HttpSession session) {
        int[] ids = validateSellerAndStore(session);
        if (ids == null) {
            return -1;
        }
        int sellerId = ids[0];
        int storeId = ids[1];

        dto.setSellerId(sellerId);
        dto.setStoreId(storeId);

        int result1 = mainProductMapper.insertmainProduct(dto);
        int result2 = 0, result3 = 0, result4 = 0;

        if (dto.getPimgUrl1() != null && !dto.getPimgUrl1().isEmpty()) {
            result2 = mainProductMapper.insertMainProductImage1(dto);
        }
        if (dto.getPimgUrl2() != null && !dto.getPimgUrl2().isEmpty()) {
            result3 = mainProductMapper.insertMainProductImage2(dto);
        }
        if (dto.getPimgUrl3() != null && !dto.getPimgUrl3().isEmpty()) {
            result4 = mainProductMapper.insertMainProductImage3(dto);
        }

        if (result1 == 1 && result2 == 1 && result3 == 1 && result4 == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public List<MainProductDTO> getProductsByMemberId(Integer memberId) {
        if (memberId == null) return Collections.emptyList();

        SellerEntity seller = sellerMapper.selectByMemberId(memberId);
        if (seller == null) {
            return Collections.emptyList();
        }

        int sellerId = seller.getSellerId();
        log.info("판매자의 sellerId: {}", sellerId);

        Integer storeId = mainProductMapper.selectStoreIdBySellerId(sellerId);
        if (storeId == null) {
            return Collections.emptyList();
        }
        log.info("조회된 storeId: {}", storeId);

        return mainProductMapper.selectProductsByStoreId(storeId);
    }

    public int updateMainProductWithImages(MainProductDTO dto, HttpSession session) {
        int[] ids = validateSellerAndStore(session);
        if (ids == null) {
            return -1; // 로그인 안됨
        }
        int sellerId = ids[0];
        int storeId = ids[1];

        dto.setSellerId(sellerId);
        dto.setStoreId(storeId);

        log.info("상품 수정 요청 - productId: {}, sellerId: {}, storeId: {}", 
            dto.getProductId(), sellerId, storeId);

        int belongs = mainProductMapper.checkProductBelongsToSellerStore(
            dto.getProductId(), sellerId, storeId
        );

        if (belongs == 0) {
            log.warn("상품이 sellerId/storeId에 속하지 않음. 권한 없음.");
            return -2;
        }

        int result1 = mainProductMapper.updateMainProduct(dto);
        int result2 = 0, result3 = 0, result4 = 0;

        if (dto.getPimgUrl1() != null && !dto.getPimgUrl1().isEmpty()) {
            result2 = mainProductMapper.updateMainProductImage1(dto);
        }
        if (dto.getPimgUrl2() != null && !dto.getPimgUrl2().isEmpty()) {
            result3 = mainProductMapper.updateMainProductImage2(dto);
        }
        if (dto.getPimgUrl3() != null && !dto.getPimgUrl3().isEmpty()) {
            result4 = mainProductMapper.updateMainProductImage3(dto);
        }

        if (result1 > 0 || result2 > 0 || result3 > 0 || result4 > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int deleteMainProduct(int productId, HttpSession session) {
        int[] ids = validateSellerAndStore(session);
        if (ids == null) {
            return -1; // 로그인 안됨
        }
        int sellerId = ids[0];
        int storeId = ids[1];

        int belongs = mainProductMapper.checkProductBelongsToSellerStore(productId, sellerId, storeId);
        if (belongs == 0) {
            log.warn("상품이 sellerId/storeId에 속하지 않음. 삭제 권한 없음.");
            return -2;
        }

        int result = mainProductMapper.deleteMainProductById(productId);
        if (result > 0) {
            log.info("상품 ID {} 삭제 성공", productId);
            return 1;
        } else {
            log.warn("상품 ID {} 삭제 실패 또는 존재하지 않음", productId);
            return 0;
        }
    }
}