package com.chacha.create.service.mainhome.store_create;

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

    public int insertMainProductWithImages(MainProductDTO dto, HttpSession session) {
        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        if (loginMember == null) {
            log.warn("로그인된 회원 정보가 없습니다.");
            return -1;
        }

        SellerEntity seller = sellerMapper.selectByMemberId(loginMember.getMemberId());
        if (seller == null) {
            log.warn("판매자 정보가 없습니다.");
            return -1;
        }

        int sellerId = seller.getSellerId();
        Integer storeId = mainProductMapper.selectStoreIdBySellerId(sellerId);
        if (storeId == null) {
            log.warn("스토어 정보가 없습니다.");
            return -1;
        }

        // DTO에 직접 세팅
        dto.setSellerId(sellerId);
        dto.setStoreId(storeId);

        mainProductMapper.insertmainProduct(dto);

        if (dto.getPimgUrl1() != null && !dto.getPimgUrl1().isEmpty()) {
            mainProductMapper.insertMainProductImage1(dto);
        }
        if (dto.getPimgUrl2() != null && !dto.getPimgUrl2().isEmpty()) {
            mainProductMapper.insertMainProductImage2(dto);
        }
        if (dto.getPimgUrl3() != null && !dto.getPimgUrl3().isEmpty()) {
            mainProductMapper.insertMainProductImage3(dto);
        }

        return 0;
    }

	public List<MainProductDTO> getProductsByMemberId(Integer memberId) {
        if (memberId == null) return Collections.emptyList();

        SellerEntity seller = sellerMapper.selectByMemberId(memberId);
        if (seller == null) {
            return Collections.emptyList();
        }

        int sellerId = seller.getSellerId();
        log.info("판매자의 sellerId: {}", sellerId);

        // sellerId → storeId 조회
        Integer storeId = mainProductMapper.selectStoreIdBySellerId(sellerId);
        if (storeId == null) {
            return Collections.emptyList();
        }
        log.info("조회된 storeId: {}", storeId);

        // storeId에 해당하는 상품들 조회
        return mainProductMapper.selectProductsByStoreId(storeId);
    }
	
	public int updateMainProductWithImages(MainProductDTO dto, HttpSession session) {
	    MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
	    if (loginMember == null) {
	        log.warn("로그인된 회원 정보가 없습니다.");
	        return -1;
	    }

	    SellerEntity seller = sellerMapper.selectByMemberId(loginMember.getMemberId());
	    if (seller == null) {
	        log.warn("판매자 정보가 없습니다.");
	        return -1;
	    }

	    int sellerId = seller.getSellerId();
	    Integer storeId = mainProductMapper.selectStoreIdBySellerId(sellerId);
	    if (storeId == null) {
	        log.warn("스토어 정보가 없습니다.");
	        return -1;
	    }

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

	    mainProductMapper.updateMainProduct(dto);

	    if (dto.getPimgUrl1() != null && !dto.getPimgUrl1().isEmpty()) {
	        mainProductMapper.updateMainProductImage1(dto);
	    }
	    if (dto.getPimgUrl2() != null && !dto.getPimgUrl2().isEmpty()) {
	        mainProductMapper.updateMainProductImage2(dto);
	    }
	    if (dto.getPimgUrl3() != null && !dto.getPimgUrl3().isEmpty()) {
	        mainProductMapper.updateMainProductImage3(dto);
	    }

	    return 0;
	}
	
	public int deleteMainProduct(int productId, HttpSession session) {
	    MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
	    if (loginMember == null) {
	        log.warn("로그인된 회원 정보가 없습니다.");
	        return -1;
	    }

	    SellerEntity seller = sellerMapper.selectByMemberId(loginMember.getMemberId());
	    if (seller == null) {
	        log.warn("판매자 정보가 없습니다.");
	        return -1;
	    }

	    int sellerId = seller.getSellerId();
	    Integer storeId = mainProductMapper.selectStoreIdBySellerId(sellerId);
	    if (storeId == null) {
	        log.warn("스토어 정보가 없습니다.");
	        return -1;
	    }

	    int belongs = mainProductMapper.checkProductBelongsToSellerStore(productId, sellerId, storeId);
	    if (belongs == 0) {
	        log.warn("상품이 sellerId/storeId에 속하지 않음. 삭제 권한 없음.");
	        return -2;
	    }
	    
	    mainProductMapper.deleteMainProductById(productId);
	    return 0;
	}
}