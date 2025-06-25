package com.chacha.create.controller.manager.report;

import java.util.Date;

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
	    // 로그인된 사용자 정보 등록
	    reportEntity.setMemberId(loginMember.getMemberId());

	    // 스토어 ID로 판매자 ID 조회
	    Integer storeId = reportEntity.getStoreId();
	    Integer sellerId = reportModalService.findSellerIdByStoreId(storeId);
	    reportEntity.setSellerId(sellerId);
	    log.info("storeID : {} sellserID : {}",storeId,sellerId);
	    // 현재 날짜 저장
	    reportEntity.setReportDate(new Date());

	    log.info("최종 insert 데이터 : {}", reportEntity);
	    
	    // 신고 등록
	    int result = reportModalService.insert(reportEntity);
	    log.info(result == 1 ? "신고 등록 성공" : "신고 등록 실패");

	    return result;
	}


}
