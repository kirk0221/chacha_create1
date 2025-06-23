package com.chacha.create.controller.seller.product_join;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.ProductlistDTO;
import com.chacha.create.common.entity.product.ProductEntity;
import com.chacha.create.service.seller.product.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/{storeUrl}/seller")
@Slf4j
public class ProductlistjoinController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/productlist")
	public List<ProductlistDTO> productlistjoin(@PathVariable String storeUrl) {
		return productService.productAllListByStoreUrl(storeUrl);
	}
	
	@PutMapping(value="/productlist", 
            consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateFlagship(@PathVariable String storeUrl, @RequestBody List<ProductlistDTO> dtoList) {
		int result = productService.updateFlagship(storeUrl, dtoList);
		return result == 0 ? "flagship 수정 성공" : "flagship 수정 실패";
	}

	@DeleteMapping(value = "/productlist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "text/plain;charset=utf-8")
	public String deleteFlagshipBatch(@RequestBody List<ProductEntity> productList) {
	    int result = productService.productDeleteByEntities(productList);
	    return result == 0 ? "delete 성공" : "delete 실패";
	}
}
