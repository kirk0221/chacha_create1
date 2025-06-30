package com.chacha.create.controller.buyer.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.HomeProductDTO;
import com.chacha.create.service.store_common.MainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/{storeUrl}")
public class StoreMainRestController {
	
	@Autowired
	private MainService mainService;
	
	// 스토어 URL 또는 storeId로 메인에 출력할 대표상품 및 인기상품 조회
	@GetMapping
	public Map<String,List<HomeProductDTO>> getStoreMainProducts(
			@PathVariable String storeUrl, 
			@RequestParam(value= "storeId", required = false) String storeIdParam) {
		
		log.info("스토어 메인 페이지 접근 : storeUrl={}, storeIdParam={}", storeUrl, storeIdParam);
		int storeId;
		// 메인 홈에서 스토어 접근 시 storeId로 인기상품 조회
		if(storeIdParam != null) {
			storeId = Integer.parseInt(storeIdParam);
		}else {	// 메인을 거치지 않고 바로 url로 스토어 접근 시 
			// 스토어URL로 스토어ID 체크
			storeId = mainService.storeIdCheck(storeUrl);
		}
		log.info("조회 대상 스토어 ID: {}", storeId);
		
		return mainService.getStoreMainProductMap(storeId);
		
	}
	
	// 스토어 전체상품 조회(조건조회)
	@GetMapping("/productlist")
	public ResponseEntity<List<HomeProductDTO>> getProductList(
	        @RequestParam int storeId,
	        @RequestParam(required = false) List<String> type,
	        @RequestParam(required = false) List<String> d,
	        @RequestParam(required = false) List<String> u,
	        @RequestParam(value = "keyword", required = false) String keyword,
	        @RequestParam(required = false, defaultValue = "latest") String sort) {

	    List<HomeProductDTO> result = mainService.getFilteredProductListWithParams(
	            storeId, type, d, u, keyword, sort
	    );
	    return ResponseEntity.ok(result);
	}


}
