package com.chacha.create.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.SellerInfoDTO;
import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.mapper.member.SellerMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StoreinfoService {
	
	@Autowired
	StoreMapper storeMapper;
	
	@Autowired
	SellerMapper sellerMapper;
	
	public List<StoreEntity> selectByStoreInfo(String storeUrl) {

		List<StoreEntity> result =  storeMapper.selectByStoreInfo(storeUrl);
		return result;
	}
	
	public List<SellerInfoDTO> selectBySellerInfo(String storeUrl){
		List<SellerInfoDTO> result = sellerMapper.selectBySellerInfo(storeUrl);
		return result;
	}
	
	
}
