package com.chacha.create.controller.seller.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.order.OrderSumDTO;
import com.chacha.create.service.SellerMainService;


@RestController
@RequestMapping("/{storeUrl}/seller")
public class SellerMainController {
	

	    @Autowired
		SellerMainService sell;

	    @GetMapping("main")
	    Map<String, List<?>> sellermain(@PathVariable String storeUrl) {
			 
	    	Map<String, List<?>> result = new HashMap<>();
	    	
	    	List<Map<String, Object>> statusList = sell.selectByStatus(storeUrl);
			List<Map<String, Object>> reviewList = sell.selectByReview(storeUrl);
			List<OrderSumDTO> orderSumList = sell.selectByDayOrderSum(storeUrl);
			
			
			result.put("statusList", statusList);
			result.put("reviewList", reviewList);
			result.put("orderSumList", orderSumList);
			
			return result;
			
		}
	
}
