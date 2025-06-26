package com.chacha.create.controller.mainhome.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.HomeDTO;
import com.chacha.create.common.dto.product.HomeProductDTO;
import com.chacha.create.service.buyer.main.MainService;
import com.chacha.create.util.ControllerUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class HomeMainRestController {
	
	@Autowired
	MainService mainService;
	
	// 메인 홈 메인페이지에서 인기스토어,인기상품,최신상품조회
	@GetMapping("/main")
	public Map<String, Object> getProductList(){
		List<HomeDTO> bestStore = mainService.selectForBestStore();
		List<HomeProductDTO> bestProduct = mainService.selectForBestProduct(null);
		List<HomeProductDTO> newProduct = mainService.selectForNewProduct();
		
		
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

	// 메인홈 전체상품 조회(조건조회)
	@GetMapping("/main/productlist")
	public ResponseEntity<List<HomeProductDTO>> getProductList(
	        @RequestParam(required = false) List<String> type,
	        @RequestParam(required = false) List<String> d,
	        @RequestParam(required = false) List<String> u,
	        @RequestParam(value = "keyword", required = false) String keyword,
	        @RequestParam(required = false) String sort) {

	    Map<String, Object> paramMap = new HashMap<>();

	    if (keyword != null && !keyword.isEmpty()) {
	        List<HomeProductDTO> result = mainService.selectByProductName(keyword);
	        log.info("메인홈에서 상품명 검색 결과 : {}", result);
	        return ResponseEntity.ok(result);
	    }

	    ControllerUtil.putParsedParam(paramMap, "type", type);
	    ControllerUtil.putParsedParam(paramMap, "d", d);
	    ControllerUtil.putParsedParam(paramMap, "u", u);

	    paramMap.put("sort", sort);

	    List<HomeProductDTO> result = mainService.selectForProductList(paramMap);
	    log.info("메인홈 조건조회 결과 : {}", result);
	    return ResponseEntity.ok(result);
	}
		
}
