package com.chacha.create.common.mapper.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.dto.product.StoreProductDTO;

/**
 * 스토어ID로 스토어의 인기상품을 조회
 */
@Mapper
public interface StoreProductMapper {
	// 스토어 인기상품 조회
	List<StoreProductDTO> selectBestProduct(int storeId);
	// 스토어 대표상품 조회
	List<StoreProductDTO> storemainProduct(int storeId);
	// 스토어 전체상품 조회(조건정렬)
	List<StoreProductDTO> selectForProductList(Map<String, Object> params);
	// 상품명으로 검색시 상품 조회
	List<StoreProductDTO> selectByProductName(Map<String, Object> params);
}
