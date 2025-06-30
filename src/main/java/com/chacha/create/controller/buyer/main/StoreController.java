package com.chacha.create.controller.buyer.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {
	
	@GetMapping("/storeAllProduct")
	public String f1() {
		return "store/storeAllProduct";
	}
	@GetMapping("/storelist")
	public String f2() {
		return "store/storelist";
	}
	@GetMapping("/mainAllProduct")
	public String f3() {
		return "main/mainHome";
	}

}
