package com.chacha.create.service.seller.product;

import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.product.ProductUpdateDTO;
import com.chacha.create.common.mapper.product.ProductUpdateMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductUpdateService {
	
	private final ProductUpdateMapper productUpdateMapper;

    public ProductUpdateDTO getProductDetail(String storeUrl, int productId) {
        return productUpdateMapper.updateProductDetail(storeUrl, productId);
    }
    
    public boolean updateProductDetail(String storeUrl, ProductUpdateDTO dto) {
        int updatedProduct = productUpdateMapper.updateProduct(dto);
        int img1 = productUpdateMapper.updateProductImage1(dto);
        int img2 = productUpdateMapper.updateProductImage2(dto);
        int img3 = productUpdateMapper.updateProductImage3(dto);
        return updatedProduct > 0 || img1 > 0 || img2 > 0 || img3 > 0;
    }
}
