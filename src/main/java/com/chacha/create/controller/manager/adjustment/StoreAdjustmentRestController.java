package com.chacha.create.controller.manager.adjustment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.manager.ManagerAdjustmentDTO;
import com.chacha.create.service.manager.adjustment.StoreAdjustmentService;

@RestController
@RequestMapping("/api")
public class StoreAdjustmentRestController {
	
	@Autowired
	StoreAdjustmentService storeAdjustmentService;
	
	@GetMapping("/manager/store/adjustment")
	List<ManagerAdjustmentDTO> storeAdjustment(){
		return storeAdjustmentService.storeAdjustment();
	}
	
}
