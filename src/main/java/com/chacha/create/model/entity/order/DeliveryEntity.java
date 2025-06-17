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
public class DeliveryEntity {
	private Integer deliveryId;
	private Integer orderId;
	private Integer deliveryCheck; //    NUMBER(1) DEFAULT 0 NOT NULL CHECK ( delivery_check IN ( 0, 1 ) ),
	private Date deliveryDate;
	private Date deliveryFinDate;
}