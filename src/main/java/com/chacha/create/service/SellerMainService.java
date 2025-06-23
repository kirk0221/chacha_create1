package com.chacha.create.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.order.OrderSumDTO;
import com.chacha.create.common.mapper.order.OrderInfoMapper;
import com.chacha.create.common.mapper.order.ReviewMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SellerMainService {

	@Autowired
	StoreMapper storeMapper;
	@Autowired
	OrderInfoMapper orderInfoMapper;
	@Autowired
	ReviewMapper reviewMapper;

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
	
	public List<Map<String, Object>> selectByReview(String storeUrl) {

		List<Map<String, Object>> result =  reviewMapper.selectByReview(storeUrl);
		return result;
	}
	
	
	

}
