package com.chacha.create.controller.buyer.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.ProductDetailDTO;
import com.chacha.create.service.buyer.detail.ProductDetailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/storeUrl")
public class ProductDetailController {
	@Autowired
	ProductDetailService productDetailService;
	
	@GetMapping("/productdetail")
    public ProductDetailDTO getProductDetail(@RequestParam int productId) {
		return productDetailService.getProductDetailWithImages(productId);
    }
}