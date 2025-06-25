package com.chacha.create.service.seller.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.product.ProductlistDTO;
import com.chacha.create.common.entity.product.PImgEntity;
import com.chacha.create.common.entity.product.ProductEntity;
import com.chacha.create.common.mapper.product.PImgMapper;
import com.chacha.create.common.mapper.product.ProductMapper;
import com.chacha.create.common.mapper.product.ProductlistMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
	
	private final PImgMapper pimgMapper;
	private final ProductMapper productMapper;
	private final ProductlistMapper productlistMapper;

	public int productimgInsert(PImgEntity p_imge) {
		return pimgMapper.insert(p_imge);
	}

	public int productInsert(ProductEntity product) {
		return productMapper.insert(product);
	}
	
	public List<ProductEntity> productlist(){
		return productMapper.selectAll();
	}
	
	public List<PImgEntity> pimglist(){
		return pimgMapper.selectAll();
	}
	
	public List<ProductlistDTO> productAllListByStoreUrl(String storeUrl){
		return productlistMapper.selectAllByStoreUrl(storeUrl);
	}

	public int updateFlagship(String storeUrl, List<ProductlistDTO> dtoList) {
	    int result = 0; // 총 업데이트된 행 수

	    for (ProductlistDTO dto : dtoList) {

	        if (dto.getFlagshipCheck() == 1) {
	            int count = productlistMapper.countFlagshipByStoreId(storeUrl);
	            if (count >= 3) {
	                System.out.println("🚫 해당 스토어(store_url=" + storeUrl + ")는 이미 대표상품이 3개입니다. 상품 ID: " + dto.getProductId());
	                continue; // 업데이트 안 함
	            }
	        }

	        int updateCount = productlistMapper.updateFlagship(dto); // 업데이트 시도
	        result += updateCount; // 총 업데이트 건수 누적

	        if (updateCount > 0) {
	            if (dto.getFlagshipCheck() == 1) {
	                System.out.println("✅ 대표상품으로 등록되었습니다. 상품 ID: " + dto.getProductId());
	            } else {
	                System.out.println("🔽 대표상품에서 해제되었습니다. 상품 ID: " + dto.getProductId());
	            }
	        } else {
	            System.out.println("❌ 업데이트 실패 또는 변경 없음: 상품 ID " + dto.getProductId());
	        }
	    }

	    return result; // 전체 업데이트 건 수 반환
	}
	
	public int productDeleteByEntities(List<ProductEntity> productList) {
	    int result = 0; // 총 업데이트된 건수 누적

	    for (ProductEntity entity : productList) {
	        int updated = productlistMapper.updateDeleteCheck(entity.getProductId());
	        if (updated > 0) {
	            System.out.println("상품 ID " + entity.getProductId() + " 논리 삭제 성공");
	            result += updated; // 누적
	        } else {
	            System.out.println("상품 ID " + entity.getProductId() + " 이미 삭제되었거나 존재하지 않음");
	        }
	    }
	    return result; // 총 업데이트된 건수 반환
	}
	
	public int getStoreIdByStoreUrl(String storeUrl) {
	    return productMapper.selectStoreIdByStoreUrl(storeUrl);
	}
	
}
