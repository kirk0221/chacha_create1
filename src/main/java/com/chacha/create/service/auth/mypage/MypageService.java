package com.chacha.create.service.auth.mypage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.mapper.member.MemberMapper;

@Service
public class MypageService {
	
	private final MemberMapper memberMapper;

	@Autowired
	public MypageService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	public int memberupdate(MemberEntity memberEntity) {
		int result = memberMapper.update(memberEntity);
		return result;
	}
	

	public int memberdelete(int memberId) {
		int result = memberMapper.delete(memberId);
		return result;
	}
	
	
	
  
}
