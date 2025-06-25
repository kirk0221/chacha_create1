package com.chacha.create.common.dto.order;

import java.util.List;

import com.chacha.create.common.entity.member.AddrEntity;
import com.chacha.create.common.entity.order.OrderDetailEntity;
import com.chacha.create.common.entity.order.OrderInfoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
	
    private OrderInfoEntity orderInfo;
    private List<OrderDetailEntity> detailList;
    private AddrEntity addr;
    
    // 새 배송지 입력 여부
    private boolean newAddr;
    
}