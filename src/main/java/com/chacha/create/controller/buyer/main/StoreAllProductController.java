package com.chacha.create.controller.buyer.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.StoreProductDTO;
import com.chacha.create.service.buyer.main.StoreMainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/{storeUrl}")
public class StoreAllProductController {
	
	@Autowired
	StoreMainService storeMainService;
	
	// 스토어 전체상품 조회(조건조회)
		@GetMapping("/productlist")
		public ResponseEntity<List<StoreProductDTO>> getProductList(
				@RequestParam int storeId,
				@RequestParam(required = false) List<String> type,
		        @RequestParam(required = false) List<String> d,
		        @RequestParam(required = false) List<String> u,
				@RequestParam(value = "keyword", required = false)  String keyword,
				@RequestParam(required = false, defaultValue = "latest") String sort,  
				Model model) {
			
				Map<String, Object> params = new HashMap<>();
				params.put("storeId", storeId);		// 해당 스토어ID의 스토어 상품 조회
				
				// 사용자가 상품명 검색시 해당 로직 수행
				if (keyword != null && !keyword.isEmpty()) {
				    Map<String, Object> paramMap = new HashMap<>();
				    params.put("keyword", keyword);

				    List<StoreProductDTO> result = storeMainService.selectByProductName(paramMap);
				    log.info("사용자가 상품명 검색 조회 : " + params);
				    return ResponseEntity.ok(result);
				} else {
				// 사용자가 카테고리별 조회시 수행
			    if (type != null) {
			    	params.put("type", type.stream().map(Integer::parseInt).collect(Collectors.toList()));
			    }
			    if (d != null) {
			    	params.put("d", d.stream().map(Integer::parseInt).collect(Collectors.toList()));
			    }
			    if (u != null) {
			    	params.put("u", u.stream().map(Integer::parseInt).collect(Collectors.toList()));
			    }

			    params.put("categoryMap", params);
			    params.put("sort", sort);
			    
			    List<StoreProductDTO> result = storeMainService.selectForProductList(params);
			    log.info("사용자가 카테고리별 조회 : " + params);
			    return ResponseEntity.ok(result);
				}
		} 
		

}
