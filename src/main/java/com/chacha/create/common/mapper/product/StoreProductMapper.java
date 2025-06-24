package com.chacha.create.common.mapper.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.entity.product.StoreProductEntity;

/**
 * 스토어ID로 스토어의 인기상품을 조회
 */
@Mapper
public interface StoreProductMapper {
	
	List<StoreProductEntity> selectBestProduct(int storeId);
	List<StoreProductEntity> storemainProduct(int storeId);
	List<StoreProductEntity> selectForProductList(Map<String, Object> params);
	List<StoreProductEntity> selectByProductName(Map<String, Object> params);
}
