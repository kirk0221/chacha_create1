package com.chacha.create.model.entity.product;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	 private Integer productId;
	 private Integer storeId;
	 private Integer typeCategoryId;
	 private Integer dCategoryId;
	 private String productName;
	 private Integer price;
	 private String productDetail;
	 private Integer stock;
	 private Date productDate;
	 private Integer saleCnt;
	 private Integer viewCnt;
}