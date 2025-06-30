package com.chacha.create.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/f")
public class PDController {
	@GetMapping("/pd")
	public String f1() {
		return "buyer/productDetail";
	}
	
	@GetMapping("/c")
	public String f2() {
		return "buyer/mypage/cart";
	}
	
	@GetMapping("/ol")
	public String f3() {
		return "buyer/mypage/orderlist";
	}
	
	@GetMapping("/od")
	public String f4() {
		return "buyer/mypage/orderdetail";
	}
	
	@GetMapping("/o")
	public String f5() {
		return "buyer/mypage/order";
	}
	
	@GetMapping("/oc")
	public String f6() {
		return "buyer/mypage/ordercomplete";
	}
	
	@GetMapping("/chat")
	public String f7() {
		return "buyer/mypage/chat";
	}
}
