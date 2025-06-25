package com.chacha.create.controller.seller.product;

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
@RequestMapping("/api/{storeUrl}/seller")
@Slf4j
public class ProductlistjoinRestController {
    
    @Autowired
    ProductService productService;
    
    // 상품 리스트 조회
    @GetMapping(value="/productlist")
    public List<ProductlistDTO> productlistjoin(@PathVariable String storeUrl) {
        return productService.productAllListByStoreUrl(storeUrl);
    }

    // 대표 상품 수정
    @PutMapping(value="/productlist", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateFlagship(@PathVariable String storeUrl, @RequestBody List<ProductlistDTO> dtoList) {
        int result = productService.updateFlagship(storeUrl, dtoList);
        return "대표상품 수정 완료: " + result + "건이 반영되었습니다.";
    }

    // 상품 삭제 (논리 삭제)
    @DeleteMapping(value = "/productlist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "text/plain;charset=utf-8")
    public String deleteFlagshipBatch(@RequestBody List<ProductEntity> productList) {
        int result = productService.productDeleteByEntities(productList);
        return "상품 삭제 완료: " + result + "건이 반영되었습니다.";
    }
}