package com.chacha.create.service.mainhome.personal;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.dto.product.PersonalProductDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.exception.NeedLoginException;
import com.chacha.create.common.mapper.product.PersonalProductMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonalProductService {

    private final PersonalProductMapper mainProductMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insertOrUpdateProductImages(PersonalProductDTO dto, boolean isInsert) {
        List<String> images = List.of(dto.getPimgUrl1(), dto.getPimgUrl2(), dto.getPimgUrl3());
        int result = 0;

        for (int i = 0; i < images.size(); i++) {
            String url = images.get(i);
            if (url != null && !url.isEmpty()) {
                if (isInsert) {
                    result += mainProductMapper.insertMainProductImage(dto.getProductId(), i + 1, url);
                } else {
                    result += mainProductMapper.updateMainProductImage(dto.getProductId(), i + 1, url);
                }
            }
        }
        return result;
    }
    
    @Transactional(rollbackFor = Exception.class)
    public int insertMainProductWithImages(PersonalProductDTO dto, MemberEntity member) {
    	if(member == null) {
    		throw new NeedLoginException("로그인이 필요합니다.");
    	}
        Map<String, Integer> idMap = mainProductMapper.selectForSellerAndStoreByMemberId(member.getMemberId());
        dto.setSellerId(idMap.get("sellerId"));
        dto.setStoreId(idMap.get("storeId"));

        int result1 = mainProductMapper.insertMainProduct(dto);
        result1 += insertOrUpdateProductImages(dto, true);

        return (result1 > 1) ? 1 : 0;
    }

    public List<PersonalProductDTO> getProductsByMemberId(MemberEntity member) {
    	if(member == null) {
    		throw new NeedLoginException("로그인이 필요합니다.");
    	}
    	Map<String, Integer> idMap = mainProductMapper.selectForSellerAndStoreByMemberId(member.getMemberId());

        return mainProductMapper.selectProductsByStoreId(idMap.get("storeId"));
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateMainProductWithImages(PersonalProductDTO dto, MemberEntity member) {
    	if(member == null) {
    		throw new NeedLoginException("로그인이 필요합니다.");
    	}
    	Map<String, Integer> idMap = mainProductMapper.selectForSellerAndStoreByMemberId(member.getMemberId());
        dto.setSellerId(idMap.get("sellerId"));
        dto.setStoreId(idMap.get("storeId"));

        log.info("상품 수정 요청 - productId: {}, sellerId: {}, storeId: {}", 
            dto.getProductId(), idMap.get("sellerId"), idMap.get("storeId"));

        int belongs = mainProductMapper.checkProductBelongsToSellerStore(
            dto.getProductId(), idMap.get("sellerId"), idMap.get("storeId"));

        if (belongs == 0) {
            log.warn("상품이 sellerId/storeId에 속하지 않음. 권한 없음.");
            return -2;
        }

        int result1 = mainProductMapper.updateMainProduct(dto);
        int result2 = insertOrUpdateProductImages(dto, false);

        if (result1 > 0 || result2 > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public int deleteMainProduct(int productId, MemberEntity member) {
    	if(member == null) {
    		throw new NeedLoginException("로그인이 필요합니다.");
    	}
    	Map<String, Integer> idMap = mainProductMapper.selectForSellerAndStoreByMemberId(member.getMemberId());
        int sellerId = idMap.get("sellerId");
        int storeId = idMap.get("storeId");

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