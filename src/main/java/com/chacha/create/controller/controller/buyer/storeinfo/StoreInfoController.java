package com.chacha.create.controller.controller.buyer.storeinfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("{storeUrl}")
public class StoreInfoController {
	
	@GetMapping("info")
	public String storeinfo() {
		return "/buyer/seller_info";
	}
}
