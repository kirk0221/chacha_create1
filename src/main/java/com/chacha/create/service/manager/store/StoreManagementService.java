package com.chacha.create.service.manager.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.mapper.store.StoreMapper;

@Service
public class StoreManagementService {
	
	private StoreMapper storeMapper;
	
	@Autowired
	public StoreManagementService(StoreMapper storeMapper){
		this.storeMapper = storeMapper;
	}
	
	public List<StoreEntity> storelist(){
		return storeMapper.selectAll();
	}
	
}
