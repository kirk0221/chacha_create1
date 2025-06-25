package com.chacha.create.controller.mainhome.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.MainHomeDTO;
import com.chacha.create.common.dto.product.StoreProductDTO;
import com.chacha.create.service.mainhome.product.MainHomeProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class HomeMainRestController {
	
	@Autowired
	MainHomeProductService mpService;
	
	// 메인 홈 메인페이지에서 인기스토어,인기상품,최신상품조회
	@GetMapping("/main")
	public Map<String, Object> getProductList(){
		List<MainHomeDTO> bestStore = mpService.selectForBestStore();
		List<StoreProductDTO> bestProduct = mpService.selectForBestProduct();
		List<StoreProductDTO> newProduct = mpService.selectForNewProduct();
		
		
		Map<String, Object> mhData = new HashMap<>();
		mhData.put("bestStore", bestStore);
		mhData.put("bestProduct", bestProduct);
		mhData.put("newProduct", newProduct);
		log.info("=============best스토어 조회============" + bestStore);
		log.info("=============best상품 조회============" + bestProduct);
		log.info("=============new상품 조회============" + newProduct);
		log.info("=============결과값 ============" + mhData);
		return mhData;
	}

}
