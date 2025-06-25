package com.chacha.create.service.buyer.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.dto.order.OrderRequestDTO;
import com.chacha.create.common.entity.member.AddrEntity;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.order.OrderDetailEntity;
import com.chacha.create.common.entity.order.OrderInfoEntity;
import com.chacha.create.common.mapper.member.AddrMapper;
import com.chacha.create.common.mapper.order.OrderDetailMapper;
import com.chacha.create.common.mapper.order.OrderInfoMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

	@Autowired
    private AddrMapper addrMapper;
	
	@Autowired
    private OrderInfoMapper orderInfoMapper;
	
	@Autowired
    private OrderDetailMapper orderDetailMapper;

    @Transactional
    public int placeOrder(OrderRequestDTO request, MemberEntity member) {
    	OrderInfoEntity order = request.getOrderInfo();
        List<OrderDetailEntity> detailList = request.getDetailList();
        AddrEntity addr = request.getAddr();
        boolean isNewAddr = request.isNewAddr();

        order.setMemberId(member.getMemberId());
        order.setOrderDate(new java.sql.Date(System.currentTimeMillis()));
        
        // 주소 입력
        if (isNewAddr) {
        	// isNewAddr = true일 경우 새 주소 입력
            addr.setMemberId(member.getMemberId());
            addrMapper.insert(addr);
            order.setAddressId(addr.getAddressId());
        } else {
        	// 프론트에서 기본 주소의 주소ID를 넘겨줄 경우
        	order.setAddressId(addr.getAddressId());
        }

        orderInfoMapper.insert(order);

        for (OrderDetailEntity detail : detailList) {
            detail.setOrderId(order.getOrderId());
            orderDetailMapper.insert(detail);
        }

        return order.getOrderId();
    }
}