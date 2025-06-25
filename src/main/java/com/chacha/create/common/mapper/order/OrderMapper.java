package com.chacha.create.common.mapper.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.dto.order.OrderDTO;
import com.chacha.create.common.dto.order.OrderSumDTO;
import com.chacha.create.common.enums.order.OrderStatusEnum;

@Mapper
public interface OrderMapper {
	List<OrderDTO> selectAll(String storeUrl);
	List<OrderDTO> selectForRefundAll(String storeUrl);
	List<OrderDTO> selectForOrderStatus(Map<String, Object> param);
	
	List<OrderDTO> selectForPersonalAll(int memberId);
	List<OrderDTO> selectForPersonalRefundAll(int memberId);
	List<OrderDTO> selectForPersonalOrderStatus(Map<String, Object> param);
	
    List<Map<String,Object>> selectByStatus(String  storeUrl);
    List<OrderSumDTO> selectByDayOrderSum(String  storeUrl);
    List<OrderStatusEnum> selectForOrderStatusOnly(String storeUrl);
}
