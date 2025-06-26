package com.chacha.create.controller.mainhome.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.HomeProductDTO;
import com.chacha.create.service.buyer.main.MainService;

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
		return mainService.getHomeMainProductMap();
	}

	// 메인홈 전체상품 조회(조건조회)
	@GetMapping("/main/productlist")
	public ResponseEntity<List<HomeProductDTO>> getProductList(
	        @RequestParam(required = false) List<String> type,
	        @RequestParam(required = false) List<String> d,
	        @RequestParam(required = false) List<String> u,
	        @RequestParam(value = "keyword", required = false) String keyword,
	        @RequestParam(required = false, defaultValue = "latest") String sort) {

	    List<HomeProductDTO> result = mainService.getFilteredProductListWithParams(
	            null, type, d, u, keyword, sort
	    );
	    return ResponseEntity.ok(result);
	}

		
}
