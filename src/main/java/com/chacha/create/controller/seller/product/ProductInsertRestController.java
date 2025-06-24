package com.chacha.create.controller.seller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chacha.create.common.dto.product.ProductWithImagesDTO;
import com.chacha.create.common.entity.product.PImgEntity;
import com.chacha.create.common.entity.product.ProductEntity;
import com.chacha.create.service.seller.product.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/{storeUrl}/seller")
@Slf4j
public class ProductInsertRestController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "sell-register", consumes = "application/json", produces = "text/plain;charset=utf-8")
    public String insertProductWithImages(@RequestBody ProductWithImagesDTO request) {
        ProductEntity product = request.getProduct();
        List<PImgEntity> images = request.getImages();

        // 1. 상품 등록
        productService.productInsert(product); // insert 후 productId가 entity에 세팅됨

        // 2. 이미지 등록
        for (PImgEntity image : images) {
            image.setProductId(product.getProductId()); // FK 설정
            productService.productimgInsert(image);
        }

        return "insert 성공";
    }
}