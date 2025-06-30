package com.chacha.create.controller.controller.seller.settlement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("{storeUrl}/seller")
public class SettlementManagementController {

	@GetMapping("/management/settlement")
	public String sellersettlement() {
		return "/main/main_personal_adjustment";
	}
}
