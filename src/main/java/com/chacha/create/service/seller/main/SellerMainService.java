package com.chacha.create.service.seller.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.order.OrderSumDTO;
import com.chacha.create.common.mapper.member.SellerMapper;
import com.chacha.create.common.mapper.order.OrderInfoMapper;
import com.chacha.create.common.mapper.order.ReviewMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SellerMainService {

	 
	final StoreMapper storeMapper;	 
	final OrderInfoMapper orderInfoMapper;	 
	final ReviewMapper reviewMapper;
	final SellerMapper sellerMapper;
	

	public Map<String, Object> selectByUrlId() {

		Map<String, Object> result = new HashMap<>();
		result.put("storeInfo", result);
		result.put(null, result);
		return result;
	}

	public List<Map<String, Object>> selectByStatus(String storeUrl) {

		List<Map<String, Object>> result =  orderInfoMapper.selectByStatus(storeUrl);
		return result;
	}
	
	public List<OrderSumDTO> selectByDayOrderSum(String storeUrl) {

		List<OrderSumDTO> result =  orderInfoMapper.selectByDayOrderSum(storeUrl);
		return result;
	}
	
	public List<Map<String, Object>> selectByStoreUrl(String storeUrl) {

		List<Map<String, Object>> result =  reviewMapper.selectByStoreUrl(storeUrl);
		return result;
	}
	
	public List<Map<String, Object>> sellManagement(int member_id) {

		List<Map<String, Object>> result =  sellerMapper.sellManagement(member_id);
		return result;
	}
	
	public List<Map<String, Object>> daySellManagement(int member_id) {

		List<Map<String, Object>> result =  sellerMapper.daySellManagement(member_id);
		return result;
	}
		
	
	
	

}
