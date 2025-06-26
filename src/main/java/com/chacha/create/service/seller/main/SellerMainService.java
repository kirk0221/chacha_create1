package com.chacha.create.service.seller.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.order.OrderSumDTO;
import com.chacha.create.common.mapper.manage.ManageMapper;
import com.chacha.create.common.mapper.order.OrderMapper;
import com.chacha.create.common.mapper.order.ReviewMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SellerMainService {

	 
	final StoreMapper storeMapper;	 
	final OrderMapper orderMapper;	 
	final ReviewMapper reviewMapper;
	final ManageMapper manageMapper;
	

	public Map<String, Object> selectByUrlId() {

		Map<String, Object> result = new HashMap<>();
		result.put("storeInfo", result);
		result.put(null, result);
		return result;
	}

	public List<Map<String, Object>> selectByStatus(String storeUrl) {

		List<Map<String, Object>> result =  orderMapper.selectByStatus(storeUrl);
		return result;
	}
	
	public List<OrderSumDTO> selectByDayOrderSum(String storeUrl) {

		List<OrderSumDTO> result =  orderMapper.selectByDayOrderSum(storeUrl);
		return result;
	}
	
	public List<Map<String, Object>> selectByStoreUrl(String storeUrl) {

		List<Map<String, Object>> result =  reviewMapper.selectByStoreUrl(storeUrl);
		return result;
	}
	
	public List<Map<String, Object>> sellManagement(int member_id) {

		List<Map<String, Object>> result =  manageMapper.sellManagement(member_id);
		return result;
	}
	
	public List<Map<String, Object>> daySellManagement(int member_id) {

		List<Map<String, Object>> result =  manageMapper.daySellManagement(member_id);
		return result;
	}
		
	
	
	

}
