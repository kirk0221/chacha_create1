package com.chacha.create.controller.controller.store_common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class AuthController {
	
	@GetMapping("/login")
	public String loginagree() {
		return "join/join_agree";
	}
	
	@GetMapping("/join/userinfo")
	public String joininfo() {
		return "join/join_info";
	}
	
	@GetMapping("/join/complete")
	public String joincomplete() {
		return "join/join_complete";
	}
	
	@GetMapping("/join/seller")
	public String logininfo() {
		return "join/join_seller";
	}
	
	
}
