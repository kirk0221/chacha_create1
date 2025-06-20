package com.chacha.create.controller.store.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.ProductDetailViewDTO;
import com.chacha.create.service.store.detail.ProductDetailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/storeUrl")
public class ProductDetailController {
	@Autowired
	ProductDetailService productDetailService;
	
	@GetMapping("/productdetail")
    public ProductDetailViewDTO getProductDetailView(@RequestParam int productId) {
		return productDetailService.selectByProductId(productId);
    }
}