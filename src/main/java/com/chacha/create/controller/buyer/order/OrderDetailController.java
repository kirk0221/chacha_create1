package com.chacha.create.controller.buyer.order;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.order.OrderDetailDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.buyer.order.OrderDetailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/main/mypage/orderdetail")
public class OrderDetailController {
	
	@Autowired
	OrderDetailService orderDetailService;
	
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetailDTO> getOrderDetail(@PathVariable int orderId, HttpSession session) {
    	MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        OrderDetailDTO dto = orderDetailService.selectByOrderId(orderId, loginMember);
        return ResponseEntity.ok(dto);
    }
}
