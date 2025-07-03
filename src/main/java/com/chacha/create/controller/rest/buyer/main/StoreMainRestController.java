package com.chacha.create.controller.rest.buyer.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.error.ApiResponse;
import com.chacha.create.common.dto.product.HomeProductDTO;
import com.chacha.create.common.enums.error.ResponseCode;
import com.chacha.create.service.store_common.MainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/{storeUrl}")
public class StoreMainRestController {

    @Autowired
    private MainService mainService;

    //스토어 대표 상품, 인기 상품 조회
    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, List<HomeProductDTO>>>> getStoreMainProducts(
            @PathVariable String storeUrl,
            @RequestParam(value = "storeId", required = false) String storeIdParam) {

        log.info("스토어 메인 페이지 접근 : storeUrl={}, storeIdParam={}", storeUrl, storeIdParam);
        int storeId;

        if (storeIdParam != null) {
            storeId = Integer.parseInt(storeIdParam);
        } else {
            storeId = mainService.storeIdCheck(storeUrl);
        }
        log.info("조회 대상 스토어 ID: {}", storeId);

        Map<String, List<HomeProductDTO>> result = mainService.getStoreMainProductMap(storeId);
        
        return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, result));
    }

    // 스토어 전체상품 조회(조건조회)
    @GetMapping("/products")
    public ResponseEntity<ApiResponse<List<HomeProductDTO>>> getProductList(
    			@PathVariable String storeUrl,
            @RequestParam(required = false) Integer storeId,
            @RequestParam(required = false) List<String> type,
            @RequestParam(required = false) List<String> d,
            @RequestParam(required = false) List<String> u,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(required = false, defaultValue = "latest") String sort) {
    		
    		if(storeId == null  || storeId == 0) {
    			storeId = mainService.storeIdCheck(storeUrl);
    		}

        List<HomeProductDTO> result = mainService.getFilteredProductListWithParams(
                storeId, type, d, u, keyword, sort);
        return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, result));
    }
    
    
}
