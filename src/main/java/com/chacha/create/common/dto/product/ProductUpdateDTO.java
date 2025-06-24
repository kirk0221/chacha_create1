package com.chacha.create.common.dto.product;

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
public class ProductUpdateDTO {

    private String pimgUrl1;
    private String pimgUrl2;
    private String pimgUrl3;

    private int productId;
    private String productName;
    private String productDetail;
    private int price;
    private int stock;

    private String typeCategoryName;
    private String uCategoryName;
    private String dCategoryName;

    private String productDate;
    private String lastModifiedDate;

    private int flagshipCheck;
}
