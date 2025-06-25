package com.chacha.create.controller.seller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.order.OrderDTO;
import com.chacha.create.common.enums.order.OrderStatusEnum;
import com.chacha.create.service.seller.order.OrderManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/{storeUrl}/seller")
public class OrderManagementRestController {

	@Autowired
	OrderManagementService orderManagementService;
	
	@GetMapping("/order/management")
	public List<OrderDTO> orderManagement(@PathVariable String storeUrl) {
		return orderManagementService.selectOrderAll(storeUrl);
	}
	
	@GetMapping("/refundlist")
	public List<OrderDTO> refundlist(@PathVariable String storeUrl){
		return orderManagementService.selectRefundAll(storeUrl);
	}
	
	@GetMapping("/orderstatus")
	public List<OrderDTO> orderStatuslist(@PathVariable String storeUrl, OrderStatusEnum orderStatus){
		return orderManagementService.selectForOrderStatus(storeUrl, orderStatus);
	}
	
	
}
