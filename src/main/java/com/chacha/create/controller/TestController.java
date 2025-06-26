package com.chacha.create.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {
	
	@GetMapping("test")
	public String test() {
		return "main/main_mypage_review";
	}
	
	
}
