package com.chacha.create.service.buyer.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.product.HomeDTO;
import com.chacha.create.common.dto.product.HomeProductDTO;
import com.chacha.create.common.mapper.product.MainPageMapper;
import com.chacha.create.common.mapper.store.StoreIdCheckMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MainService{
	
	@Autowired
	private MainPageMapper mainPageMapper;
	@Autowired
	private StoreIdCheckMapper idCheckMapper;
	
	// 스토어 전체 상품 조회(조건 정렬)
	public List<HomeProductDTO> selectForProductList(Map<String,Object>params){
		log.info("스토어에서 전체상품(조건조회) 조회 요청 : {}",params);
		return mainPageMapper.selectForProductList(params);
	}
	
	// 스토어에서 사용자가 상품명 검색시 조회
	public List<HomeProductDTO> selectByProductName(String keyword){
		log.info("상품명으로 검색 조회 요청 : {}", keyword);
		return mainPageMapper.selectByProductName(keyword);
	}
	
	// 인기상품 조회
	public List<HomeProductDTO> selectForBestProduct(Integer storeId) {
		log.info("인기 상품 조회 요청: {}", storeId);
		return mainPageMapper.selectForBestProduct(storeId);
	}

	// 스토어
	
	// 스토어의 대표상품 조회
	public List<HomeProductDTO> storeMainProduct(int storeId) {
		log.info("스토어의 대표 상품 조회 요청: {}", storeId);
		return mainPageMapper.selectForStoreMainProduct(storeId);
	}

	
	// 해당 스토어URL의 스토어ID체크
	public int storeIdCheck(String storeUrl) {
		Integer storeId = idCheckMapper.selectByStoreUrl(storeUrl);
		log.info("스토어 URL로 스토어 ID 조회 요청 : {}",storeUrl);
		return storeId;
	}
	
	// 메인홈
	
	public  List<HomeDTO> selectForBestStore(){
		log.info("메인홈에서 인기스토어 조회");
		return mainPageMapper.selectForBestStore();
	}
	
	public  List<HomeProductDTO> selectForNewProduct(){
		log.info("메인홈에서 최신 상품 조회");
		return mainPageMapper.selectForNewProduct();
	}


	

}

