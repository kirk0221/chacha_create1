package com.chacha.create.service.buyer.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.dto.order.OrderDetailDTO;
import com.chacha.create.common.dto.order.OrderListDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.enums.order.OrderStatusEnum;
import com.chacha.create.common.mapper.order.OrderMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderDetailService {

    @Autowired
    private OrderMapper orderMapper;
    
    @Transactional
    public OrderDetailDTO selectByOrderId(int orderId, MemberEntity member) {
    	int memberId = member.getMemberId();
        // 주문 상세 조회
        OrderDetailDTO dto = orderMapper.selectOrderDetailByOrderId(orderId, memberId);

		// 주문 상세 내 상품 목록 조회
		List<OrderListDTO> orderlist = orderMapper.selectOrderListByOrderId(orderId, memberId);
		dto.setOrderItems(orderlist);

		// 배송 상태 체크
		// OrderListService.java와 중복 로직(추후 분리 필요)
		for (OrderListDTO item : orderlist) {
			Integer check = item.getDeliveryCheck();

			switch (check) {
			case 0:
				item.setDeliveryStatus("배송 전");
				break;
			case 1:
				item.setDeliveryStatus("배송 중");
				break;
			case 2:
				item.setDeliveryStatus("배송 완료");
				break;
			default:
				item.setDeliveryStatus("정보 없음");
			}
		}

        // 총 금액 계산 (상품 가격 총합)
		int total = 0;
		for (OrderListDTO item : orderlist) {
		    total += item.getOrderPrice();
		}
		dto.setTotalAmount(total);
		
		String cardNum = orderMapper.selectCardNumByOrderId(orderId);
	    dto.setMaskedCardNum(maskCardNumber(cardNum));

		dto.setCanCancel(isCancelable(dto.getOrderStatus()));
		dto.setCanRefund(isRefundable(dto.getOrderStatus()));
		dto.setCanWriteReview(canWriteReview(dto.getOrderStatus()));

        return dto;
    }
    
    // 카드 번호 보안(뒤 네 자리만 나오도록)
    private String maskCardNumber(String cardNum) {
        if (cardNum == null || cardNum.length() < 4) return "";
        return "****-****-****-" + cardNum.substring(cardNum.length() - 4);
	}

    // ORDER_OK일 때만 true 반환(취소 가능)
    private boolean isCancelable(OrderStatusEnum status) {
        return status == OrderStatusEnum.ORDER_OK;
    }

    // ORDER_OK일 때만 true 반환(환불 가능)
    private boolean isRefundable(OrderStatusEnum status) {
        return status == OrderStatusEnum.ORDER_OK;
    }

    // ORDER_OK거나 CONFIRM일 경우에만 true 반환(리뷰 작성 가능)
    private boolean canWriteReview(OrderStatusEnum status) {
        return status == OrderStatusEnum.ORDER_OK || status == OrderStatusEnum.CONFIRM;
    }
}
