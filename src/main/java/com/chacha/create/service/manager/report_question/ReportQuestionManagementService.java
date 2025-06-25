package com.chacha.create.service.manager.report_question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.AlterMessageEntity;
import com.chacha.create.common.entity.store.QuestionEntity;
import com.chacha.create.common.entity.store.ReportEntity;
import com.chacha.create.common.mapper.member.AlterMessageMapper;
import com.chacha.create.common.mapper.store.QuestionMapper;
import com.chacha.create.common.mapper.store.ReportMapper;

@Service
public class ReportQuestionManagementService {

	private final ReportMapper reportMapper;
	private final AlterMessageMapper alterMessageMapper;
	private final QuestionMapper questionMapper;
	
	@Autowired
	public ReportQuestionManagementService(ReportMapper reportMapper, AlterMessageMapper alterMessageMapper, QuestionMapper questionMapper){
		this.reportMapper = reportMapper;
		this.alterMessageMapper = alterMessageMapper;
		this.questionMapper = questionMapper;
	}
	
	public List<ReportEntity> selectForReportAll() {
		return reportMapper.selectAll();
	}
	
	public int insert(AlterMessageEntity alterMessageEntity) {
		return alterMessageMapper.insert(alterMessageEntity);
	}
	
	public List<QuestionEntity> selectForQuestionAll(){
		return questionMapper.selectAll();
	}
}
