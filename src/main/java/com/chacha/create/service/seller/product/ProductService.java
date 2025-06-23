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
		pimgMapper.insert(p_imge);
		return 0;
	}

	public int productInsert(ProductEntity product) {
		productMapper.insert(product);
		return 0;
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
	    for (ProductlistDTO dto : dtoList) {

	        if (dto.getFlagshipCheck() == 1) {
	            int count = productlistMapper.countFlagshipByStoreId(storeUrl);
	            if (count >= 3) {
	                System.out.println("🚫 해당 스토어(store_url=" + storeUrl + ")는 이미 대표상품이 3개입니다. 상품 ID: " + dto.getProductId());
	                continue; // 업데이트 안함
	            }
	        }

	        productlistMapper.updateFlagship(dto);
	        if (dto.getFlagshipCheck() == 1) {
	            System.out.println("✅ 대표상품으로 등록되었습니다. 상품 ID: " + dto.getProductId());
	        } else {
	            System.out.println("🔽 대표상품에서 해제되었습니다. 상품 ID: " + dto.getProductId());
	        }
	    }
	    return 0;
	}

	public int productDeleteByEntities(List<ProductEntity> productList) {
	    for (ProductEntity entity : productList) {
	        int updated = productlistMapper.updateDeleteCheck(entity.getProductId());
	        if (updated > 0) {
	            System.out.println("상품 ID " + entity.getProductId() + " 논리 삭제 성공");
	        } else {
	            System.out.println("상품 ID " + entity.getProductId() + " 이미 삭제되었거나 존재하지 않음");
	        }
	    }
	    return 0;
	}
	
}
