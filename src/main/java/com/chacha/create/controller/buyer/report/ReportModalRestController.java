package com.chacha.create.controller.buyer.report;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.store.ReportEntity;
import com.chacha.create.service.manager.report.ReportModalService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
public class ReportModalRestController {
	
	@Autowired
	ReportModalService reportModalService;
	
	@PostMapping("/reportAjax")
	public int insertReport(@RequestBody ReportEntity reportEntity, HttpSession session) {
	    log.info("신고 요청 데이터 : {}", reportEntity);

	    // 로그인 여부 확인
	    MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");

	    // 신고 등록
	    int result = reportModalService.insert(loginMember, reportEntity);
	    log.info(result == 1 ? "신고 등록 성공" : "신고 등록 실패");

	    return result;
	}

}
