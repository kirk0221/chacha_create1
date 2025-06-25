package com.chacha.create.service.manager.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.store.ReportEntity;
import com.chacha.create.common.mapper.store.ReportMapper;

@Service
public class ReportModalService {
	
	private ReportMapper reportMapper;
	
	@Autowired
	public ReportModalService(ReportMapper reportMapper){
		this.reportMapper = reportMapper;
	}
	
	public int insert(ReportEntity reportEntity) {
		return reportMapper.insert(reportEntity);
	}

	public Integer findSellerIdByStoreId(int storeId) {
		return reportMapper.findSellerIdByStoreId(storeId);
	}

}
