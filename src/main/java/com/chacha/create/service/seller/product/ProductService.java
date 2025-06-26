package com.chacha.create.service.seller.product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.dto.product.ProductUpdateDTO;
import com.chacha.create.common.dto.product.ProductWithImagesDTO;
import com.chacha.create.common.dto.product.ProductlistDTO;
import com.chacha.create.common.entity.product.PImgEntity;
import com.chacha.create.common.entity.product.ProductEntity;
import com.chacha.create.common.mapper.product.PImgMapper;
import com.chacha.create.common.mapper.product.ProductManageMapper;
import com.chacha.create.common.mapper.product.ProductMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
	
	private final PImgMapper pimgMapper;
	private final ProductMapper productMapper;
	private final ProductManageMapper productDetailMapper;

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
		return productDetailMapper.selectAllByStoreUrl(storeUrl);
	}

	@Transactional(rollbackFor = Exception.class)
	public int updateFlagship(String storeUrl, List<ProductlistDTO> dtoList) {
	    int result = 0; // 총 업데이트된 행 수

	    for (ProductlistDTO dto : dtoList) {

	        if (dto.getFlagshipCheck() == 1) {
	            int count = productDetailMapper.countFlagshipByStoreId(storeUrl);
	            if (count >= 3) {
	                log.info("🚫 해당 스토어(store_url=" + storeUrl + ")는 이미 대표상품이 3개입니다. 상품 ID: " + dto.getProductId());
	                continue; // 업데이트 안 함
	            }
	        }

	        int updateCount = productDetailMapper.updateFlagship(dto); // 업데이트 시도
	        result += updateCount; // 총 업데이트 건수 누적

	        if (updateCount > 0) {
	            if (dto.getFlagshipCheck() == 1) {
	            	log.info("✅ 대표상품으로 등록되었습니다. 상품 ID: " + dto.getProductId());
	            } else {
	            	log.info("🔽 대표상품에서 해제되었습니다. 상품 ID: " + dto.getProductId());
	            }
	        } else {
	        	log.info("❌ 업데이트 실패 또는 변경 없음: 상품 ID " + dto.getProductId());
	        }
	    }

	    return result; // 전체 업데이트 건 수 반환
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int productDeleteByEntities(List<ProductEntity> productList) {
	    int result = 0; // 총 업데이트된 건수 누적

	    for (ProductEntity entity : productList) {
	        int updated = productDetailMapper.updateDeleteCheck(entity.getProductId());
	        if (updated > 0) {
	            log.info("상품 ID " + entity.getProductId() + " 논리 삭제 성공");
	            result += updated; // 누적
	        } else {
	        	log.info("상품 ID " + entity.getProductId() + " 이미 삭제되었거나 존재하지 않음");
	        }
	    }
	    return result; // 총 업데이트된 건수 반환
	}
	
    public ProductUpdateDTO getProductDetail(String storeUrl, int productId) {
        return productDetailMapper.updateProductDetail(storeUrl, productId);
    }
    
    public boolean updateProductDetail(String storeUrl, ProductUpdateDTO dto) {
        int updatedProduct = productDetailMapper.updateProduct(dto);
        int img1 = productDetailMapper.updateProductImages(dto);
        return updatedProduct > 0 || img1 > 0;
    }
	
    @Transactional(rollbackFor = Exception.class)
    public int registerProductWithImages(String storeUrl, ProductWithImagesDTO request) {
        ProductEntity product = request.getProduct();
        List<PImgEntity> images = request.getImages();

        // Store_Url → store_id 조회
        product.setStoreId(productMapper.selectForStoreIdByStoreUrl(storeUrl));

        // 1. 상품 등록
        int productInsertResult = productInsert(product);
        if (productInsertResult <= 0) {
            log.info("insert 실패 (상품 등록 실패)");
            return 0;
        }

        // 2. 이미지 등록
        int imgInsertSuccessCount = 0;
        int seq = 1;
        for (PImgEntity image : images) {
            image.setProductId(product.getProductId()); // FK 설정
            image.setPimgSeq(seq++); // 이미지 시퀀스가 자동으로 증가
            int imgInsertResult = productimgInsert(image);
            if (imgInsertResult > 0) {
                imgInsertSuccessCount++;
            }
        }

        if (imgInsertSuccessCount == images.size()) {
            log.info("insert 성공");
            return 1;
        } else {
            log.info("insert 실패 (이미지 등록 일부 또는 전체 실패)");
            return 0;
        }
    }
    
}
