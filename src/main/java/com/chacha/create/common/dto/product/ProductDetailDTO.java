package com.chacha.create.common.dto.product;

import java.util.List;

import com.chacha.create.common.entity.product.ProductDetailEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    private ProductDetailEntity productDetail;
    private List<String> thumbnailImageUrls;
    private List<String> descriptionImageUrls;
    private String mainThumbnailUrl;
}
