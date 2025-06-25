package com.chacha.create.service.seller.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.mapper.member.SellerMapper;

@Service
public class SellerSettlementManagementService {
	
	@Autowired
	SellerMapper sellerMapper;
	
	public List<Map<String, Object>> sellerSettlementManagement(String storeUrl){
		return sellerMapper.sellerSettlementManagement(storeUrl);
	}
	
	public List<Map<String, Object>> sellerDaySellManagement(String storeUrl){
		return sellerMapper.sellerDaySellManagement(storeUrl);
	}
}
