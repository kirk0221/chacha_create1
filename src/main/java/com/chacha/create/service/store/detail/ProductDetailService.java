package com.chacha.create.service.store.detail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.dto.product.ProductDetailDTO;
import com.chacha.create.common.dto.product.ProductDetailViewDTO;
import com.chacha.create.common.entity.product.PImgEntity;
import com.chacha.create.common.enums.image.ProductImageTypeEnum;
import com.chacha.create.common.mapper.product.PImgMapper;
import com.chacha.create.common.mapper.product.ProductDetailMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductDetailService {
	@Autowired
	private PImgMapper pImgMapper;
	
	@Autowired
	private ProductDetailMapper productDetailMapper;
	
	@Transactional
	public ProductDetailViewDTO selectByProductId(int productId) {
	    ProductDetailDTO productDetail = productDetailMapper.selectByProductId(productId);
	    List<PImgEntity> pImgList = pImgMapper.selectByProductId(productId);

	    List<String> thumbnailUrls = new ArrayList<>();
	    List<String> descriptionUrls = new ArrayList<>();
	    String mainThumbnailUrl = null;
	    int minSeq = Integer.MAX_VALUE;

	    for (PImgEntity img : pImgList) {
	        if (ProductImageTypeEnum.THUMBNAIL.equals(img.getPimgEnum())) {
	            thumbnailUrls.add(img.getPimgUrl());
	            if (img.getPimgSeq() != null && img.getPimgSeq() < minSeq) {
	                minSeq = img.getPimgSeq();
	                mainThumbnailUrl = img.getPimgUrl();
	            }
	        } else if (ProductImageTypeEnum.DESCRIPTION.equals(img.getPimgEnum())) {
	            descriptionUrls.add(img.getPimgUrl());
	        }
	    }
	    
	    ProductDetailViewDTO detailDTO = ProductDetailViewDTO.builder()
	    		.productDetail(productDetail)
	    	    .thumbnailImageUrls(thumbnailUrls)
	    	    .descriptionImageUrls(descriptionUrls)
	    	    .mainThumbnailUrl(mainThumbnailUrl)
	    	    .build();

	    return detailDTO;
	}
}