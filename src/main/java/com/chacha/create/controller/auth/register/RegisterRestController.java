package com.chacha.create.controller.auth.register;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.service.auth.register.RegisterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/auth/join")
public class RegisterRestController {
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping(value = "/userinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public MemberEntity userinfo(HttpSession session, @RequestBody MemberEntity memberEntity) {
		MemberEntity member = null;
		member = registerService.memberinsert(memberEntity);
		log.info("member 정보 입력 완료 : " + member.toString());
		session.setAttribute("loginMember", member);
		return member;
	}
	
	@PostMapping(value = "/seller", produces = MediaType.APPLICATION_JSON_VALUE)
	public int seller(HttpSession session, @RequestBody SellerEntity sellerEntity) {
		MemberEntity member = (MemberEntity) session.getAttribute("loginMember");
		int result = registerService.sellerinsert(sellerEntity, member);
		log.info("RegisterRestController에서 Seller에 "+result + "개 입력");
		return result;
	}
	
}
