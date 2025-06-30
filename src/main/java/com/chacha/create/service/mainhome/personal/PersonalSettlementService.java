package com.chacha.create.service.mainhome.personal;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.exception.NeedLoginException;
import com.chacha.create.common.mapper.manage.ManageMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalSettlementService {

	private final ManageMapper manageMapper;
	
	public List<Map<String, Object>> sellManagement(MemberEntity loginMember) {
    	if(loginMember == null) {
    		throw new NeedLoginException("로그인이 필요합니다.");
    	}
		List<Map<String, Object>> result =  manageMapper.sellManagement(loginMember.getMemberId());
		return result;
	}
	
	public List<Map<String, Object>> daySellManagement(MemberEntity loginMember) {
    	if(loginMember == null) {
    		throw new NeedLoginException("로그인이 필요합니다.");
    	}

		List<Map<String, Object>> result =  manageMapper.daySellManagement(loginMember.getMemberId());
		return result;
	}
}
