package com.chacha.create.controller.controller.store_common;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}
	
	@GetMapping("/join/agree")
	public String joinAgree() {
		return "auth/join/joinAgree";
	}
	
	@GetMapping("/join/userinfo")
	public String joinInfo() {
		return "auth/join/joinInfo";
	}
	
	@GetMapping("/join/complete")
	public String joinComplete() {
		return "auth/join/joinComplete";
	}
	
	@GetMapping("/join/seller")
	public String loginInfo() {
		return "auth/join/joinSeller";
	}
	
	@GetMapping("/logout")
	public String logout_page(HttpSession session) {
		session.invalidate();
		return "redirect:main";
	}
}
