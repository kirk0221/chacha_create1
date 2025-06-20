package com.chacha.create.common.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.entity.product.ProductEntity;

/**
 * 스토어ID로 스토어의 인기상품을 조회
 */
@Mapper
public interface StoreProductMapper {
	
	List<ProductEntity> selectBestProduct(int storeId);
	List<ProductEntity> storemainProduct(int storeId);

}
