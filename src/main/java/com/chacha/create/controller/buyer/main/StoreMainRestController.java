package com.chacha.create.controller.buyer.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.StoreProductDTO;
import com.chacha.create.service.buyer.main.StoreMainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/{storeUrl}")
public class StoreMainRestController {
	
	@Autowired
	private StoreMainService storeMainService;
	
	// 스토어 URL 또는 storeId로 메인에 출력할 대표상품 및 인기상품 조회
	@GetMapping
	public Map<String,List<StoreProductDTO>> getStoreMainProducts(
			@PathVariable String storeUrl, 
			@RequestParam(value= "storeId", required = false) String storeIdParam) {
		
		log.info("스토어 메인 페이지 접근 : storeUrl={}, storeIdParam={}", storeUrl, storeIdParam);
		
		int storeId;
		// 메인 홈에서 스토어 접근 시 storeId로 인기상품 조회
		if(storeIdParam != null) {
			storeId = Integer.parseInt(storeIdParam);
		}else {	// 메인을 거치지 않고 바로 url로 스토어 접근 시 
			// 스토어URL로 스토어ID 체크
			storeId = storeMainService.storeIdCheck(storeUrl);
		}
		
		log.info("조회 대상 스토어 ID: {}", storeId);
		
		// 해당 스토어의 인기 상품 조회
		List<StoreProductDTO> bestProduct = storeMainService.selectBestProduct(storeId);
		// 해당 스토어의 대표 상품 조회
		List<StoreProductDTO> mainProduect = storeMainService.storeMainProduct(storeId);
		
		 Map<String, List<StoreProductDTO>> spData = new HashMap<>();
			 spData.put("bestProduct", bestProduct);
			 spData.put("mainProduct", mainProduect);

		
		return spData;
	}
	
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
