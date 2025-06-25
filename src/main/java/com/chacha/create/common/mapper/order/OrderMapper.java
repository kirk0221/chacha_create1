package com.chacha.create.common.mapper.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.dto.order.OrderDTO;
import com.chacha.create.common.dto.order.OrderListDTO;

@Mapper
public interface OrderMapper {
	List<OrderDTO> selectAll(String storeUrl);
	List<OrderDTO> selectRefundAll(String storeUrl);
	List<OrderDTO> selectForOrderStatus(Map<String, Object> param);
	
	List<OrderListDTO> selectOrderListByMemberId(int memberId);
}