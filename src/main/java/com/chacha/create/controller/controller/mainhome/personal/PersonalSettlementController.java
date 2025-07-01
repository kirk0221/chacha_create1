package com.chacha.create.controller.controller.mainhome.personal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/sell")
public class PersonalSettlementController {

	@GetMapping("/manage")
	public String sellmanage() {
		return "/main/personal/storeInfo";
	}
}
