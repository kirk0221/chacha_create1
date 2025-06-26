package com.chacha.create.service.buyer.storeinfo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.member.SellerInfoDTO;
import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.mapper.manage.ManageMapper;
import com.chacha.create.common.mapper.member.SellerMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StoreInfoService {
	
	@Autowired
	StoreMapper storeMapper;
	
	@Autowired
	ManageMapper manageMapper;
	
	public List<StoreEntity> selectByStoreInfo(String storeUrl) {

		List<StoreEntity> result =  storeMapper.selectByStoreInfo(storeUrl);
		return result;
	}
	
	public List<SellerInfoDTO> selectBySellerInfo(String storeUrl){
		List<SellerInfoDTO> result = manageMapper.selectBySellerInfo(storeUrl);
		return result;
	}
	
}
