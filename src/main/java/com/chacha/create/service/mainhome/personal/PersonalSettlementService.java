package com.chacha.create.service.mainhome.personal;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.chacha.create.common.mapper.manage.ManageMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalSettlementService {

	private final ManageMapper manageMapper;
	
	public List<Map<String, Object>> sellManagement(int member_id) {

		List<Map<String, Object>> result =  manageMapper.sellManagement(member_id);
		return result;
	}
	
	public List<Map<String, Object>> daySellManagement(int member_id) {

		List<Map<String, Object>> result =  manageMapper.daySellManagement(member_id);
		return result;
	}
}
