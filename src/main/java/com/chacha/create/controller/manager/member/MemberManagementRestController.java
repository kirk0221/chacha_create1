package com.chacha.create.controller.manager.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.manager.member.MemberManagementService;

@RestController
public class MemberManagementRestController {
	
	@Autowired
	MemberManagementService memberManagementService;
	
	@GetMapping("manager/userlist")
	public List<MemberEntity> userlist(){
		return memberManagementService.selectAll();
	}
	
	@GetMapping("manager/userinfo")
	public MemberEntity userinfo(int memberId) {
		return memberManagementService.selectById(memberId);
	}
	
}
