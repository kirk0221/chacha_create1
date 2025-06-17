package com.chacha.create.model.entity.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class StoreEntity {
	private Integer storeId;
	private Integer sellerId;
	private String logoImg;
	private String storeName;
	private String storeDetail;
	private String storeUrl;
	private Integer saleCnt;
	private Integer viewCnt;


}
