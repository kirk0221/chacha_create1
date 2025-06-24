package com.chacha.create.service.manager.adjustment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.manager.ManagerAdjustmentDTO;
import com.chacha.create.common.mapper.store.StoreMapper;

@Service
public class StoreAdjustmentService {
	
	@Autowired
	StoreMapper storeMapper;
	
	public List<ManagerAdjustmentDTO> storeAdjustment(){
		return storeMapper.storeAdjustment();
	}

}
