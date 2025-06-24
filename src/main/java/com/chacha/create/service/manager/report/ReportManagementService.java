package com.chacha.create.service.manager.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.AlterMessageEntity;
import com.chacha.create.common.entity.store.ReportEntity;
import com.chacha.create.common.mapper.member.AlterMessageMapper;
import com.chacha.create.common.mapper.store.ReportMapper;

@Service
public class ReportManagementService {

	private ReportMapper reportMapper;
	private AlterMessageMapper alterMessageMapper;
	
	@Autowired
	public ReportManagementService(ReportMapper reportMapper, AlterMessageMapper alterMessageMapper){
		this.reportMapper = reportMapper;
		this.alterMessageMapper = alterMessageMapper;
	}
	
	public List<ReportEntity> selectAll() {
		return reportMapper.selectAll();
	}
	
	public int insert(AlterMessageEntity alterMessageEntity) {
		return alterMessageMapper.insert(alterMessageEntity);
	}
}
