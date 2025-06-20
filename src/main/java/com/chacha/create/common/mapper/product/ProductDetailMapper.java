package com.chacha.create.common.mapper.product;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.entity.product.ProductDetailEntity;

@Mapper
public interface ProductDetailMapper {
	// 상품 아이디로 상품 상세 정보 조회
	ProductDetailEntity selectProductDetail(int productId);
}