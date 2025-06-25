package com.chacha.create.controller.mainhome.question;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.store.QuestionEntity;
import com.chacha.create.service.mainhome.question.QuestionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/main")
public class QuestionRestController {
	
	@Autowired
	QuestionService questionService;

	@GetMapping("/question")
	public List<QuestionEntity> questionlist(){
		return questionService.selectForQuestionAll();
	}
	
	@PostMapping("/question")
	public int insertQuestion(@RequestBody QuestionEntity questionEntity, HttpSession session){
		MemberEntity memberEntity = (MemberEntity) session.getAttribute("loginMember");
		return questionService.insertQuestion(memberEntity, questionEntity);
	}
	
}
