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
    public String insertProductWithImages(@PathVariable("storeUrl") String storeUrl, @RequestBody ProductWithImagesDTO request) {
        ProductEntity product = request.getProduct();
        List<PImgEntity> images = request.getImages();

        // Store_Url -> store_id 조회
        int storeId = productService.getStoreIdByStoreUrl(storeUrl);
        product.setStoreId(storeId);

        // 1. 상품 등록
        int productInsertResult = productService.productInsert(product); // insert 후 productId가 entity에 세팅됨

        if (productInsertResult <= 0) {
            return "insert 실패 (상품 등록 실패)";
        }

        // 2. 이미지 등록
        int imgInsertSuccessCount = 0;
        for (PImgEntity image : images) {
            image.setProductId(product.getProductId()); // FK 설정
            int imgInsertResult = productService.productimgInsert(image);
            if (imgInsertResult > 0) {
                imgInsertSuccessCount++;
            }
        }

        if (imgInsertSuccessCount == images.size()) {
            return "insert 성공";
        } else {
            return "insert 실패 (이미지 등록 일부 또는 전체 실패)";
        }
    }
}