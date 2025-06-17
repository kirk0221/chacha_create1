package com.chacha.create.model.entity.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {
    private Integer cartId;
    private Integer memberId;
    private Integer productId;
    private Integer productCnt;
}