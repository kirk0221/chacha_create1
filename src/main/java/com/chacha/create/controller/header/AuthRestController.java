package com.chacha.create.controller.header;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.service.header.auth.LoginService;
import com.chacha.create.service.header.auth.RegisterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/auth")
public class AuthRestController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping(value = "/login" , produces = MediaType.APPLICATION_JSON_VALUE)
	public int login(HttpSession session, @RequestBody MemberEntity member) {
		MemberEntity memberEntity = null;
		
		memberEntity = loginService.login(member.getMemberEmail(), member.getMemberPwd());
		
		if(memberEntity == null) return 0;
		
		session.setAttribute("loginMember", memberEntity);
		
		return 1;
	}
	
	@PostMapping(value = "/join/userinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public MemberEntity userinfo(HttpSession session, @RequestBody MemberEntity memberEntity) {
		MemberEntity member = null;
		member = registerService.memberinsert(memberEntity); // 받아온 멤버 정보로 정보 입력
		log.info("member 정보 입력 완료 : " + member.toString());
		if(member != null) {
			session.setAttribute("loginMember", member); // 바로 로그인
		}
		return member;
	}
	
	@PostMapping(value = "/join/seller", produces = MediaType.APPLICATION_JSON_VALUE)
	public int seller(HttpSession session, @RequestBody SellerEntity sellerEntity) {
		MemberEntity member = (MemberEntity) session.getAttribute("loginMember"); // 세션에서 로그인한 사용자 정보를 가져옴
		int result = registerService.sellerinsert(sellerEntity, member); // 받아온 판매자 정보를 입력
		log.info("RegisterRestController에서 Seller에 "+result + "개 입력");
		return result;
	}
}
