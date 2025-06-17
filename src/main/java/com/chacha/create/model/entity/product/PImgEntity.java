package com.chacha.create.model.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PImgEntity {
	private Integer pImgId;
    private Integer productId;
    private String pImgUrl;
    private String pImgEnum; // VARCHAR2(20) NOT NULL CHECK ( p_img_enum IN ( 'THUMBNAIL', 'DESCRIPTION' ) ),
    private Integer pImgSeq;
}