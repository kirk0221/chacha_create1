package com.chacha.create.service.seller.settlement;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.mapper.manage.ManageMapper;
import com.chacha.create.common.mapper.product.PImgMapper;
import com.chacha.create.common.mapper.product.ProductManageMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SettlementManagementService {
	
	private final ManageMapper manageMapper;
	
	public List<Map<String, Object>> sellerSettlementManagement(String storeUrl){
		return manageMapper.sellerSettlementManagement(storeUrl);
	}
	
	public List<Map<String, Object>> sellerDaySellManagement(String storeUrl){
		return manageMapper.sellerDaySellManagement(storeUrl);
	}
}
