package com.chacha.create.service.buyer.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.order.OrderListDTO;
import com.chacha.create.common.mapper.order.OrderMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderListService {
	
	@Autowired
    private OrderMapper orderMapper;

    public List<OrderListDTO> getOrderList(int memberId) {
        List<OrderListDTO> orderlist = orderMapper.selectOrderListByMemberId(memberId);

        // 배송 상태 체크
		for (OrderListDTO dto : orderlist) {
			Integer check = dto.getDeliveryCheck();

			switch (check) {
			case 0:
				dto.setDeliveryStatus("배송 전");
				break;
			case 1:
				dto.setDeliveryStatus("배송 중");
				break;
			case 2:
				dto.setDeliveryStatus("배송 완료");
				break;
			default:
				dto.setDeliveryStatus("정보 없음");
			}
		}

        return orderlist;
    }
}
