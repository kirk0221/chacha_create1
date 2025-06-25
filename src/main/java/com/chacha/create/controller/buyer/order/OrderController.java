package com.chacha.create.controller.buyer.order;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.order.OrderRequestDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.buyer.order.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/main/order")
public class OrderController {
	
	@Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> getOrder(@RequestBody OrderRequestDTO orderRequest,
    																HttpSession session) {
        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        if (loginMember == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 필요");
        }

        int resultOrderId = orderService.placeOrder(orderRequest, loginMember);
        return ResponseEntity.ok("주문이 완료되었습니다. 주문번호: " + resultOrderId);
    }
}