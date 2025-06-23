package com.chacha.create.service.manager.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.mapper.member.MemberMapper;

@Service
public class MemberManagementService {

	private MemberMapper memberMapper;

	@Autowired
	public MemberManagementService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	public List<MemberEntity> selectAll() {
		return memberMapper.selectAll();
	}
	
	public MemberEntity selectById(int memberId) {
		return memberMapper.selectByMemberId(memberId);
	}

}
