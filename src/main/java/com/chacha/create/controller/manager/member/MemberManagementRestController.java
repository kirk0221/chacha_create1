package com.chacha.create.controller.manager.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.AlterMessageEntity;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.manager.member.MemberManagementService;
import com.chacha.create.service.manager.report_question.ReportQuestionManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/manager")
@Slf4j
public class MemberManagementRestController {
	
	@Autowired
	MemberManagementService memberManagementService;
	
	@GetMapping("/userlist")
	public List<MemberEntity> userlist(){
		return memberManagementService.selectAll();
	}
	
	@GetMapping("/userinfo")
	public MemberEntity userinfo(int memberId) {
		return memberManagementService.selectById(memberId);
	}
}
