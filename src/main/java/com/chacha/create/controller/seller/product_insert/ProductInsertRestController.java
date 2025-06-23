package com.chacha.create.controller.seller.product_insert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.product.ProductEntity;
import com.chacha.create.service.seller.product.ProductService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/{storeUrl}/seller/sell-register")
@Slf4j
public class ProductInsertRestController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(value="/productinsert",
			produces="text/plain;charset=utf-8", consumes = "application/json")
	public String f1(@RequestBody ProductEntity productentity) {
		System.out.println(productentity);
		int result = productService.productInsert(productentity);
		return result==0?"insert 성공":"insert 실패";
	}
	
	@GetMapping(value="/productlist")
	public List<ProductEntity> productlist() {
		return productService.productlist();
	}
}
