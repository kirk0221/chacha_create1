package com.chacha.create.controller.seller.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.service.seller.main.SellerSettlementManagementService;

@RestController
@RequestMapping("/{storeUrl}")
public class SellerSettlementManagementController {

	@Autowired
	SellerSettlementManagementService ssmService;
	
	@GetMapping("/seller/settlement/management")
	Map<String, List<?>> sellerSettlementManagement(@PathVariable String storeUrl){
		
		Map<String, List<?>> result = new HashMap<>();
		
		List<Map<String, Object>> settlementList = ssmService.sellerSettlementManagement(storeUrl);
		List<Map<String, Object>> settlementByDayList = ssmService.sellerDaySellManagement(storeUrl);
		
		result.put("settlementByDayList", settlementByDayList);
		result.put("settlementList", settlementList);
		
		return result;
		
	}
	
	
}
