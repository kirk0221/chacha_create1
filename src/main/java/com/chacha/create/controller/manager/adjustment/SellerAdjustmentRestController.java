package com.chacha.create.controller.manager.adjustment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.manager.ManagerAdjustmentDTO;
import com.chacha.create.service.manager.adjustment.SellerAdjustmentService;

@RestController
@RequestMapping("/api")
public class SellerAdjustmentRestController {
	
	@Autowired
	SellerAdjustmentService sellerAdjustmentService;
	
	@GetMapping("/manager/seller/adjustment")
	List<ManagerAdjustmentDTO> sellerAdjustment(){
		return sellerAdjustmentService.sellerAdjustment();
	}

}
