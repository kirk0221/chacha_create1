package com.chacha.create.controller.auth.register;

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
	RegisterService registerService;
	
	@PostMapping(value = "/userinfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public int userinfo(@RequestBody MemberEntity memberEntity) {
		int result = registerService.memberinsert(memberEntity);
		log.info("RegisterRestController에서 Member에 "+result + "개 입력");
		return result;
	}
	
	@PostMapping(value = "/seller", produces = MediaType.APPLICATION_JSON_VALUE)
	public int seller(@RequestBody SellerEntity sellerEntity) {
		int result = registerService.sellerinsert(sellerEntity);
		log.info("RegisterRestController에서 Seller에 "+result + "개 입력");
		return result;
	}
	
}
