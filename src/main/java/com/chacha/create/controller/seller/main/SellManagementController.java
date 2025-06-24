package com.chacha.create.controller.seller.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.seller.main.SellerMainService;

@RestController
public class SellManagementController {
	
	@Autowired
	SellerMainService sellerMainService;
	
	@GetMapping("/main/sell/management")
	Map<String, List<?>> sellmanagement(HttpSession session) {
		
		MemberEntity member= (MemberEntity) session.getAttribute("loginMember");
		
		Map<String, List<?>> result = new HashMap<>();
		
		List<Map<String, Object>> sellmanageList = sellerMainService.sellManagement(5);
		List<Map<String, Object>> daySellmanagelist = sellerMainService.daySellManagement(5);
		
		result.put("sellmanageList", sellmanageList);
		result.put("daySellmanagelist", daySellmanagelist);
		
		return result;
	}
}
