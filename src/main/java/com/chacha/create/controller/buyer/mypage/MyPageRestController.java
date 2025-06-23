package com.chacha.create.controller.buyer.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.store.mypage.MypageService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/storeUrl/mypage")
public class MyPageRestController {

	@Autowired
	private MypageService mypageService;

	@PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public int mypageupdate(@RequestBody MemberEntity memberEntity) {
			int result = mypageService.memberupdate(memberEntity);
		return result;
	}
	
	@PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public int mypagedelete(@RequestParam int memberId) {
			int result = mypageService.memberdelete(memberId);
		return result;
	}

}
