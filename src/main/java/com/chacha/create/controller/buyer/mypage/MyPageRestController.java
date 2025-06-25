package com.chacha.create.controller.buyer.mypage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.buyer.mypage.MypageService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/{storeUrl}/mypage")
public class MyPageRestController {

	@Autowired
	private MypageService mypageService;

	@PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public int mypageupdate(HttpSession session) {
		MemberEntity member= (MemberEntity) session.getAttribute("loginMember");
		int result = mypageService.memberupdate(member);
		return result;
	}
	
	@PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public int mypagedelete(HttpSession session) {
		MemberEntity member= (MemberEntity) session.getAttribute("loginMember");
		int result = mypageService.memberdelete(member.getMemberId());
		return result;
	}

}
