package com.chacha.create.model.entity.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {
    private Integer cardId;
    private Integer memberId;
    private String cardNum;
    private String cardCompany;
    private String cardToken;
    private String cardAlias;
}