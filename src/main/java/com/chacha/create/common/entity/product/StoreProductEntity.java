package com.chacha.create.common.entity.product;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreProductEntity {
	
	private Integer productId;
    private Integer storeId;
    private Integer typeCategoryId;
    private Integer dCategoryId;
    private String productName;

    private Integer price;

    /**
     * 상품 상세 설명 (DB에서는 CLOB 타입으로 저장)
     */
    private String productDetail;

    private Integer stock;
    private Date productDate;
    private Integer saleCnt;
    private Integer viewCnt;
    private Date lastModifiedDate;
    private Integer flagshipCheck;
	
	/**
     * 인기 상품 조회시 필요한 필드 추가
     */
    private String typeCategoryName; 	// 카테고리명
    private String dCategoryName;    		// 하위 카테고리명
    private String uCategoryName;    		// 상위 카테고리명
    private String pImgUrl;          				// 대표 이미지 URL (P_IMG_SEQ = 1)

}
