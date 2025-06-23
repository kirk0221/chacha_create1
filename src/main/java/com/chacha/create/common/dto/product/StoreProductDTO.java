package com.chacha.create.common.dto.product;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreProductDTO {

    private Integer productId;
    private Integer storeId;
    private Integer typeCategoryId;
    private Integer dCategoryId;
    private String productName;
    private Integer price;
    private String productDetail;      		// 상품 상세 설명 (DB에서는 CLOB 타입으로 저장)
    private Integer stock;
    private Date productDate;
    private Integer saleCnt;
    private Integer viewCnt;
    private Date lastModifiedDate;
    private Integer flagshipCheck;

    // 조회 시 조인용 필드
    private String typeCategoryName;   	// 대분류 카테고리명
    private String dCategoryName;      	// 중분류 카테고리명
    private String uCategoryName;      	// 소분류 카테고리명
    private String pImgUrl;            			// 대표 이미지 URL (P_IMG_SEQ = 1)
}
