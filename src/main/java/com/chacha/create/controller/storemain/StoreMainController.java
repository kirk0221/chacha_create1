package com.chacha.create.controller.storemain;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.product.ProductEntity;
import com.chacha.create.service.storemain.StoreMainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class StoreMainController {
	
	@Autowired
	StoreMainService storeMainService;
	
	@GetMapping("/{storeUrl}")
	//@GetMapping("/storeUrl")
	public List<ProductEntity> storeMain(@PathVariable String storeUrl, @RequestParam(value= "storeId", required = false) String storeIdParam) {
		
		int storeId;
		// 메인 홈에서 스토어 접근 시 storeId로 인기상품 조회
		if(storeIdParam != null) {
			storeId = Integer.parseInt(storeIdParam);
		}else {	// 메인을 거치지 않고 바로 url로 스토어 접근 시 
			// 스토어URL로 스토어ID 체크
			storeId = storeMainService.storeIdCheck(storeUrl);
		}
		
		// 해당 스토어의 인기 상품 조회
		List<ProductEntity> BestProduct = storeMainService.selectBestProduct(storeId);
		// 해당 스토어의 대표 상품 조회
		List<ProductEntity> MainProduct = storeMainService.storemainProduct(storeId);
		
		return MainProduct;
	}

}
