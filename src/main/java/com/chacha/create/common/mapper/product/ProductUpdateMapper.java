package com.chacha.create.common.mapper.product;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.chacha.create.common.dto.product.ProductUpdateDTO;

@Mapper
public interface ProductUpdateMapper {
	ProductUpdateDTO updateProductDetail(@Param("storeUrl") String storeUrl,
            @Param("productId") int productId);
	
	int updateProduct(ProductUpdateDTO dto);
	int updateProductImage1(ProductUpdateDTO dto);
	int updateProductImage2(ProductUpdateDTO dto);
	int updateProductImage3(ProductUpdateDTO dto);
}
