package com.chacha.create.service.manager.store;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.mapper.store.StoreMapper;

@Service
@RequestMapping("/manager")
public class StoreManagementService {
	
	private StoreMapper storeMapper;
	
	StoreManagementService(StoreMapper storeMapper){
		this.storeMapper = storeMapper;
	}
	
	@GetMapping("/storelist")
	public List<StoreEntity> storelist(){
		return storeMapper.selectAll();
	}
	
}
