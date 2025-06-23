package com.chacha.create.common.entity.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSumDTO {
	private String saleDate;
	private Integer total;
	
}
