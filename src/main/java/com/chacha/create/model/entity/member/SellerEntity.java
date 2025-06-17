package com.chacha.create.model.entity.member;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SellerEntity {
	private Integer sellerId;
	private Integer memberId;
	private Date openingDate;
	private String account;
	private String accountBank;
	private String profileInfo;


}
