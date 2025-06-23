package com.chacha.create.service.seller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.product.ProductEntity;
import com.chacha.create.common.mapper.product.StoreProductMapper;
import com.chacha.create.common.mapper.store.StoreIdCheckMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StoreMainService{
	
	@Autowired
	private StoreProductMapper storeProductMapper;
	@Autowired
	private StoreIdCheckMapper idCheckMapper;
	
	
	
	
	// 해당 스토어URL의 스토어ID체크
	public int storeIdCheck(String storeUrl) {
		Integer storeId = idCheckMapper.selectBystoreUrl(storeUrl);
		return storeId;
	}

	// 스토어의 인기상품 조회
	public List<ProductEntity> selectBestProduct(int storeId) {
		return storeProductMapper.selectBestProduct(storeId);
	}

	public List<ProductEntity> storemainProduct(int storeId) {
		return storeProductMapper.storemainProduct(storeId);
	}

}

