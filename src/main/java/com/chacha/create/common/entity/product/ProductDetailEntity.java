package com.chacha.create.common.entity.product;

import java.sql.Date;

import com.chacha.create.common.enums.category.UCategoryEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailEntity {
	// ProductEntity
    private Integer productId;
    private Integer storeId;
    private Integer typeCategoryId;
    private Integer dCategoryId;
    private String productName;
    private Integer price;
    private String productDetail;
    private Integer stock;
    private Date productDate;
    private Date lastModifiedDate;
    private Integer saleCnt;
    private Integer viewCnt;
    private Integer flagshipCheck;

    // DCategoryEntity
    private UCategoryEnum uCategoryId;
    private String dCategoryName;
    
    // UCategoryEntity
    private String uCategoryName;
    
    // TypeCategoryEntity
    private String typeCategoryName;
}