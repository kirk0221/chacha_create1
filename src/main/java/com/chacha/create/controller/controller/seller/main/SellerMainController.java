package com.chacha.create.controller.controller.seller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/{storeUrl}/seller")
public class SellerMainController {
	
	@GetMapping("/main")
	public String sellerMain() {
		return "/seller/mypage_seller";
	}
}
