package com.chacha.create.model.entity.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailEntity {
	private Integer orderDetailId;
	private Integer orderId;
	private Integer productId;
	private Integer orderCnt;
	private Integer orderPrice;
}