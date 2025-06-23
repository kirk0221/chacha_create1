package com.chacha.create.service.auth.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.mapper.member.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {

	private final MemberMapper memberMapper;
	
	@Autowired
	public LoginService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	public MemberEntity login(String memberEmail, String memberPwd) {
		MemberEntity memberEntity = null;
		
		memberEntity = memberMapper.selectByMemberEmail(memberEmail);
		
		if(memberEntity == null) {
			log.info("아이디가 틀림 : " + memberEmail);
			return null;
		}else if(memberEmail.equals(memberEntity.getMemberPwd())) {
			log.info("로그인 성공");
			return memberEntity;
		}
		log.info("비밀번호가 틀림");
		return null;
	}
	
}
