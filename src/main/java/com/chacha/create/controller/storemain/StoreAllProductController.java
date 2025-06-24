package com.chacha.create.controller.storemain;

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

import com.chacha.create.common.entity.product.StoreProductEntity;
import com.chacha.create.service.storemain.StoreMainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/{storeUrl}")
public class StoreAllProductController {
	
	@Autowired
	StoreMainService storeMainService;
	
	// 스토어 전체상품 조회(조건조회)
		@GetMapping("/productlist")
		public ResponseEntity<List<StoreProductEntity>> getProductList(
				@RequestParam int storeId,
				@RequestParam(required = false) List<String> type,
		        @RequestParam(required = false) List<String> d,
		        @RequestParam(required = false) List<String> u,
				@RequestParam(value = "keyword", required = false)  String keyword,
				@RequestParam(required = false, defaultValue = "latest") String sort,  
				Model model) {
			
				Map<String, Object> params = new HashMap<>();
				params.put("storeId", storeId);
				
				if (keyword != null && !keyword.isEmpty()) {
				    Map<String, Object> paramMap = new HashMap<>();
				    params.put("keyword", keyword);

				    List<StoreProductEntity> result = storeMainService.selectByProductName(paramMap);
				    return ResponseEntity.ok(result);
				} else {
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
			    
			    List<StoreProductEntity> result = storeMainService.selectForProductList(params);
			    return ResponseEntity.ok(result);
				}
		} 
		

}
