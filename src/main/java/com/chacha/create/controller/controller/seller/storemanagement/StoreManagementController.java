package com.chacha.create.controller.controller.seller.storemanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{storeUrl}/seller")
public class StoreManagementController {

	@GetMapping("/management/seller")
	public String storeManagement() {
		return "seller/closure";
	}
}
