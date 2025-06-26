package com.chacha.create.controller.mainhome.personal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.mainhome.personal.PersonalSettlementService;

@RestController
@RequestMapping("/api")
public class PersonalSettlementRestController {
	
	@Autowired
	PersonalSettlementService personalSettlementService;
	
	@GetMapping("/main/sell/management")
	Map<String, List<?>> sellmanagement(HttpSession session) {
		MemberEntity member = (MemberEntity) session.getAttribute("loginMember");
		Map<String, List<?>> result = new HashMap<>();
		List<Map<String, Object>> sellmanageList = personalSettlementService.sellManagement(member.getMemberId());
		List<Map<String, Object>> daySellmanagelist = personalSettlementService.daySellManagement(member.getMemberId());
		
		result.put("sellmanageList", sellmanageList);
		result.put("daySellmanagelist", daySellmanagelist);
		
		return result;
	}
}
