package com.chacha.create.controller.buyer.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.order.OrderListDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.buyer.order.OrderListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/main/mypage")
public class OrderListRestController {
	
	@Autowired
	OrderListService orderListService;
	
    @GetMapping("/orderlist")
    public ResponseEntity<List<OrderListDTO>> showOrderList(HttpSession session) {
        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        int memberId = loginMember.getMemberId();
        List<OrderListDTO> orderList = orderListService.getOrderList(memberId);
        return ResponseEntity.ok(orderList);
    }
}
