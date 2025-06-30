package com.chacha.create.controller.seller.settlement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.service.seller.settlement.SettlementManagementService;

@RestController
@RequestMapping("/api/{storeUrl}")
public class SettlementManagementRestController {

	@Autowired
	SettlementManagementService ssmService;
	
	@GetMapping("/seller/management/settlement")
	Map<String, List<?>> sellerSettlementManagement(@PathVariable String storeUrl){
		
		Map<String, List<?>> result = new HashMap<>();
		
		List<Map<String, Object>> settlementList = ssmService.sellerSettlementManagement(storeUrl);
		List<Map<String, Object>> settlementByDayList = ssmService.sellerDaySellManagement(storeUrl);
		
		result.put("settlementByDayList", settlementByDayList);
		result.put("settlementList", settlementList);
		
		return result;
		
	}
	
	
}
