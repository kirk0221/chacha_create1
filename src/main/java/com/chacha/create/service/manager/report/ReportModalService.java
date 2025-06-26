package com.chacha.create.service.manager.report;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.store.ReportEntity;
import com.chacha.create.common.mapper.store.ReportMapper;
import com.chacha.create.common.mapper.store.StoreMapper;
import com.chacha.create.controller.buyer.report.ReportModalRestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportModalService {
	
	private final ReportMapper reportMapper;
	private final StoreMapper storeMapper;
	
	public int insert(MemberEntity loginMember, ReportEntity reportEntity) {
		// 로그인된 사용자 정보 등록
	    reportEntity.setMemberId(loginMember.getMemberId());

	    // 스토어 ID로 판매자 ID 조회
	    Integer storeId = reportEntity.getStoreId();
	    Integer sellerId = storeMapper.selectForSellerIdByStoreId(storeId);
	    reportEntity.setSellerId(sellerId);
	    log.info("storeID : {} sellserID : {}",storeId,sellerId);
	    // 현재 날짜 저장
	    reportEntity.setReportDate(new Date());

	    log.info("최종 insert 데이터 : {}", reportEntity);
		return reportMapper.insert(reportEntity);
	}

}
