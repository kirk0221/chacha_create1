package com.chacha.create.controller.mainhome.personal;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.order.OrderDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.order.OrderInfoEntity;
import com.chacha.create.common.enums.order.OrderStatusEnum;
import com.chacha.create.service.mainhome.personal.OrderManageService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/main/sell")
public class OrderManageController {
	
	@Autowired
	OrderManageService orderManageService;

	@GetMapping("/order/management")
	public List<OrderDTO> orderManagement(HttpSession session) {
		MemberEntity memberEntity = (MemberEntity) session.getAttribute("loginMember");
		return orderManageService.selectOrderAll(memberEntity);
	}
	
	@GetMapping("/refundlist")
	public List<OrderDTO> refundlist(HttpSession session){
		MemberEntity memberEntity = (MemberEntity) session.getAttribute("loginMember");
		return orderManageService.selectRefundAll(memberEntity);
	}
	
	@GetMapping("/orderstatus")
	public List<OrderDTO> orderStatuslist(HttpSession session, OrderStatusEnum orderStatus){
		MemberEntity memberEntity = (MemberEntity) session.getAttribute("loginMember");
		return orderManageService.selectForOrderStatus(memberEntity, orderStatus);
	}
	
	@PutMapping("/orderstatus")
	public int updateOrderStatus(@RequestBody OrderInfoEntity orderInfoEntity){
		int result = 0;
		result = orderManageService.updateForRefundStatus(orderInfoEntity);
		return result;
	}
}
