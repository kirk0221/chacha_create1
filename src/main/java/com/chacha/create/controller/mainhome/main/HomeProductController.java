package com.chacha.create.controller.mainhome.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.StoreProductDTO;
import com.chacha.create.common.entity.product.StoreProductEntity;
import com.chacha.create.service.mainhome.product.MainHomeProductService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class HomeProductController {
	
	@Autowired
	MainHomeProductService mpService;
	
	// 메인홈 전체상품 조회(조건조회)
	@GetMapping("/main/productlist")
	public ResponseEntity<List<StoreProductDTO>> getProductList(
	        @RequestParam(required = false) List<String> type,
	        @RequestParam(required = false) List<String> d,
	        @RequestParam(required = false) List<String> u,
	        @RequestParam(value = "keyword", required = false)  String keyword,
	        @RequestParam(required = false) String sort) {
		
		Map<String, List<Integer>> parsedMap = new HashMap<>();
		
		if(keyword != null && !keyword.isEmpty()) {
			List<StoreProductDTO> result = mpService.selectByProductName(keyword);
			log.info("메인홈에서 상품명 검색 결과 : " + result);
			return ResponseEntity.ok(result);
		} else {

	    
	    if (type != null) {
	        parsedMap.put("type", type.stream().map(Integer::parseInt).collect(Collectors.toList()));
	    }
	    if (d != null) {
	        parsedMap.put("d", d.stream().map(Integer::parseInt).collect(Collectors.toList()));
	    }
	    if (u != null) {
	        parsedMap.put("u", u.stream().map(Integer::parseInt).collect(Collectors.toList()));
	    }

	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("categoryMap", parsedMap);
	    paramMap.put("sort", sort);
	    
	    List<StoreProductDTO> result = mpService.selectForProductList(paramMap);
	    log.info("메인홈에서 조건조회 결과 : " + result);
	    return ResponseEntity.ok(result);
		}
	}

}
