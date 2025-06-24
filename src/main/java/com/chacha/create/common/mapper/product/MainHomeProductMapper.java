package com.chacha.create.common.mapper.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.dto.product.StoreProductDTO;

/**
 * 메인 홈에서 개인판매자의 전체상품 조회
 */
@Mapper
public interface MainHomeProductMapper {
		// 개인판매자들의 전체 상품 조회(조건,카테고리별)
	    List<StoreProductDTO> selectForProductList(Map<String, Object> params);
		// 상품명으로 검색시 해당 상품 조회 
	    List<StoreProductDTO> selectByProductName(String keyword);
	
}
