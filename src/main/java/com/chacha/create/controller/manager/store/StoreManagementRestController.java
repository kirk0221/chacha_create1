package com.chacha.create.controller.manager.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.service.manager.store.StoreManagementService;

@RestController
@RequestMapping("/manager")
public class StoreManagementRestController {
	
	@Autowired
	StoreManagementService storeManagementService;
	
	@GetMapping("/storelist")
	public List<StoreEntity> storelist(){
		return storeManagementService.storelist();
	}
	
}
