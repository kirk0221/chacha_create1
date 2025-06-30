package com.chacha.create.service.manager.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.mapper.product.PImgMapper;
import com.chacha.create.common.mapper.product.ProductManageMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreManagementService {
	
	private final StoreMapper storeMapper;
	
	public List<StoreEntity> storelist(){
		return storeMapper.selectAll();
	}
	
}
