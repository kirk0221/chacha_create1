package com.chacha.create.common.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.chacha.create.common.dto.ProductlistDTO;

/*
 * {@code product} 상품 조회 리스트 조인에 대한 MyBatis 매퍼 인터페이스입니다.
 * 상품 join 조회 및 수정, 삭제 기능을 제공합니다.
 */
@Mapper
public interface ProductlistMapper {
	
	List<ProductlistDTO> selectAllByStoreUrl(String storeUrl);

	int updateFlagship(ProductlistDTO dto);
	
	int countFlagshipByStoreId(String storeUrl);

	int updateDeleteCheck(int productId);
}

