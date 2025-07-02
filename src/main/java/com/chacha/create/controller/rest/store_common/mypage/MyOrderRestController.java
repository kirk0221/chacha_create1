package com.chacha.create.controller.rest.store_common.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.error.ApiResponse;
import com.chacha.create.common.dto.order.OrderDetailDTO;
import com.chacha.create.common.dto.order.OrderListDTO;
import com.chacha.create.common.entity.member.AddrEntity;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.enums.error.ResponseCode;
import com.chacha.create.service.store_common.mypage.MyOrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/main/mypage")
public class MyOrderRestController {
	
	@Autowired
	private MyOrderService myOrderService;

    // 주문 목록 조회
	@GetMapping("/orders")
    public ResponseEntity<ApiResponse<List<OrderListDTO>>> showOrderList(HttpSession session) {
        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");

        if (loginMember == null) {
            return ResponseEntity.status(ResponseCode.UNAUTHORIZED.getStatus())
                                 .body(new ApiResponse<>(ResponseCode.UNAUTHORIZED, null));
        }

        List<OrderListDTO> orderList = myOrderService.getOrderList(loginMember.getMemberId());

        return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, orderList));
    }
	
	// 기본배송지 설정
	@GetMapping("/order/addr")
	public ResponseEntity<ApiResponse<AddrEntity>> getDefaultAddr(HttpSession session){
		MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
		AddrEntity addrEntity = myOrderService.baseAddr(loginMember);
		log.info(addrEntity.toString());
		if(addrEntity != null) {
			return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, addrEntity));
		}
		return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, null));
	}

    // 주문 상세 조회
    @GetMapping("/orderdetail/{orderId}")
    public ResponseEntity<ApiResponse<OrderDetailDTO>> getOrderDetail(@PathVariable int orderId, HttpSession session) {
        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");

        if (loginMember == null) {
            return ResponseEntity.status(ResponseCode.UNAUTHORIZED.getStatus())
                                 .body(new ApiResponse<>(ResponseCode.UNAUTHORIZED, null));
        }

        OrderDetailDTO dto = myOrderService.selectByOrderId(orderId, loginMember);

        if (dto == null) {
            return ResponseEntity.status(ResponseCode.NOT_FOUND.getStatus())
                                 .body(new ApiResponse<>(ResponseCode.NOT_FOUND, null));
        }

        return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, dto));
    }
}

