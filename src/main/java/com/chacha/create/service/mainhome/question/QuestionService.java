package com.chacha.create.service.mainhome.question;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.store.QuestionEntity;
import com.chacha.create.common.mapper.store.QuestionMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuestionService {

	private final QuestionMapper questionMapper;
	
	public QuestionService(QuestionMapper questionMapper) {
		this.questionMapper = questionMapper;
	}
	
	public List<QuestionEntity> selectForQuestionAll(){
		return questionMapper.selectAll();
	}
	
	public int insertQuestion(MemberEntity memberEntity, QuestionEntity questionEntity) {
		questionEntity.setMemberId(memberEntity.getMemberId());
		return questionMapper.insert(questionEntity);
	}
	
}
