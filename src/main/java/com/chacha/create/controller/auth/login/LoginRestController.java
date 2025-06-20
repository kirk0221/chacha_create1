package com.chacha.create.controller.auth.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.auth.login.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/auth")
public class LoginRestController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/login" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String login(HttpSession session, @RequestBody MemberEntity member) {
		MemberEntity memberEntity = null;
		
		memberEntity = loginService.login(member.getMemberEmail(), member.getMemberPwd());
		
		if(memberEntity == null) return "로그인 실패";
		
		session.setAttribute("loginMember", memberEntity);
		
		return "로그인 성공";
		
	}
}
