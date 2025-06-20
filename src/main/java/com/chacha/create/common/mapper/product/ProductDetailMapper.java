package com.chacha.create.common.mapper.product;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.dto.product.ProductDetailDTO;

@Mapper
public interface ProductDetailMapper {
	// 상품 아이디로 상품 상세 정보+이미지 url 조회
	ProductDetailDTO selectByProductId(int productId);
}