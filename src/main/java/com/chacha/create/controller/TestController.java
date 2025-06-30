package com.chacha.create.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TestController {
	
	@GetMapping("test")
	public String test() {
		return "/buyer/seller_info";
	}
	
	
}