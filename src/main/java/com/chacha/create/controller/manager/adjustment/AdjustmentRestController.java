package com.chacha.create.controller.manager.adjustment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.manager.ManagerAdjustmentDTO;
import com.chacha.create.service.manager.adjustment.AdjustmentService;

@RestController
@RequestMapping("/api/manager/adjustment")
public class AdjustmentRestController {
	
	@Autowired
	AdjustmentService adjustmentService;
	
	@GetMapping("/store")
	List<ManagerAdjustmentDTO> storeAdjustment(){
		return adjustmentService.storeAdjustment();
	}
	
	@GetMapping("/seller")
	List<ManagerAdjustmentDTO> sellerAdjustment(){
		return adjustmentService.sellerAdjustment();
	}

}
