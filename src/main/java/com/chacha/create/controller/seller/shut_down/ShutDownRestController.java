package com.chacha.create.controller.seller.shut_down;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.auth.login.LoginService;
import com.chacha.create.service.seller.shut_down.ShutDownService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/{StoreUrl}/seller")
public class ShutDownRestController {

	@Autowired
	ShutDownService shutDownService;
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/close")
	public int colse(HttpSession session, @PathVariable String StoreUrl, @RequestBody MemberEntity memberEntity) {
		
		MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
		
		MemberEntity member = loginService.login(memberEntity.getMemberEmail(), memberEntity.getMemberPwd());
		
		if(member != null && loginMember.equals(member)) {
			try {
				return shutDownService.shutdown(StoreUrl);
			}
			catch(IllegalStateException e) {
				return 0;
			}
		}
		
		return 0;
		
	}
}
