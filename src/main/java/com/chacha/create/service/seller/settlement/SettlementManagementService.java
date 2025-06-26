package com.chacha.create.service.seller.settlement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.mapper.manage.ManageMapper;

@Service
public class SettlementManagementService {
	
	@Autowired
	ManageMapper manageMapper;
	
	public List<Map<String, Object>> sellerSettlementManagement(String storeUrl){
		return manageMapper.sellerSettlementManagement(storeUrl);
	}
	
	public List<Map<String, Object>> sellerDaySellManagement(String storeUrl){
		return manageMapper.sellerDaySellManagement(storeUrl);
	}
}
