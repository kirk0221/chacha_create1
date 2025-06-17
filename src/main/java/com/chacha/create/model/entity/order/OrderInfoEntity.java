package com.chacha.create.model.entity.order;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoEntity {
	private Integer orderId;
	private Integer memberId;
	private Date orderDate;
	private String orderName;
	private String orderPhone;
	private Integer addressId;
	private Integer cardId;
}