package com.chacha.create.model.entity.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    private Integer addressId;
    private Integer memberId;
    private String postNum;
    private String addressRoad;
    private String addressDetail;
    private String addressExtra;
    private Integer addressCheck;
}