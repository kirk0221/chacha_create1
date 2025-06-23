package com.chacha.create.controller.store.buyermain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.StoreProductDTO;
import com.chacha.create.service.store.buyermain.StoreMainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class StoreMainController {
	
	@Autowired
	private StoreMainService storeMainService;
	
	// 스토어 URL 또는 storeId로 메인에 출력할 대표상품 및 인기상품 조회
	@GetMapping("/{storeUrl}")
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
			storeId = storeMainService.selectByStoreIdCheck(storeUrl);
		}
		
		log.info("조회 대상 스토어 ID: {}", storeId);
		
		// 해당 스토어의 인기 상품 조회
		List<StoreProductDTO> bestProduct = storeMainService.selectFofBestProduct(storeId);
		// 해당 스토어의 대표 상품 조회
		List<StoreProductDTO> mainProduect = storeMainService.selectForMainProduct(storeId);
		
		 Map<String, List<StoreProductDTO>> spData = new HashMap<>();
			 spData.put("bestProduct", bestProduct);
			 spData.put("mainProduct", mainProduect);

		
		return spData;
	}

}
