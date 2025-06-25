package com.chacha.create.service.mainhome.personal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.dto.order.OrderDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.order.OrderInfoEntity;
import com.chacha.create.common.enums.order.OrderStatusEnum;
import com.chacha.create.common.mapper.order.OrderInfoMapper;
import com.chacha.create.common.mapper.order.OrderMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderManageService {

	private final OrderMapper orderMapper;
	private final OrderInfoMapper orderInfoMapper;
	
	public OrderManageService(OrderMapper orderMapper, OrderInfoMapper orderInfoMapper) {
		this.orderMapper = orderMapper;
		this.orderInfoMapper = orderInfoMapper;
	}
	
	public List<OrderDTO> selectOrderAll(MemberEntity memberEntity) {
		return orderMapper.selectForPersonalAll(memberEntity.getMemberId());
	}
	
	public List<OrderDTO> selectRefundAll(MemberEntity memberEntity){
		return orderMapper.selectForPersonalRefundAll(memberEntity.getMemberId());
	}
	
	public List<OrderDTO> selectForOrderStatus(MemberEntity memberEntity, OrderStatusEnum orderStatus){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("memberId", memberEntity.getMemberId());
		paramMap.put("orderStatus", orderStatus);
		return orderMapper.selectForPersonalOrderStatus(paramMap);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int updateForRefundStatus(OrderInfoEntity orderInfoEntity) {
		orderInfoEntity.setOrderStatus(OrderStatusEnum.REFUND_OK);
		return orderInfoMapper.updateForOrderStatus(orderInfoEntity);
	}
	
}
