package com.chacha.create.controller.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.order.OrderDetailDTO;
import com.chacha.create.common.dto.order.OrderListDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.buyer.order.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/main/mypage")
public class MyOrderRestController {
	
	@Autowired
	OrderService orderService;
	
    @GetMapping("/orderlist")
    public ResponseEntity<List<OrderListDTO>> showOrderList(HttpSession session) {
        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        int memberId = loginMember.getMemberId();
        List<OrderListDTO> orderList = orderService.getOrderList(memberId);
        return ResponseEntity.ok(orderList);
    }
	
    @GetMapping("/orderdetail/{orderId}")
    public ResponseEntity<OrderDetailDTO> getOrderDetail(@PathVariable int orderId, HttpSession session) {
    	MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        OrderDetailDTO dto = orderService.selectByOrderId(orderId, loginMember);
        return ResponseEntity.ok(dto);
    }
}
