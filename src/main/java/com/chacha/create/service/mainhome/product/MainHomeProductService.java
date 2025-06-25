package com.chacha.create.service.mainhome.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.product.MainHomeDTO;
import com.chacha.create.common.dto.product.StoreProductDTO;
import com.chacha.create.common.mapper.product.MainHomeProductMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MainHomeProductService {
	
	@Autowired
	private MainHomeProductMapper mpMapper;
	
	public List<StoreProductDTO> selectForProductList(Map<String, Object> params) {
		log.info("메인홈에서 전체상품 조회(카테고리별or조건 조회 : " + params);
        return mpMapper.selectForProductList(params);
    }
	
	public  List<StoreProductDTO> selectByProductName(String keyword){
		log.info("메인홈에서 상품명 : " + keyword+ "으로 검색");
		return mpMapper.selectByProductName(keyword);
	}
	
	public  List<MainHomeDTO> selectForBestStore(){
		log.info("메인홈에서 인기스토어 조회");
		return mpMapper.selectForBestStore();
	}
	
	public  List<StoreProductDTO> selectForBestProduct(){
		log.info("메인홈에서 인기 상품 조회");
		return mpMapper.selectForBestProduct();
	}
	
	public  List<StoreProductDTO> selectForNewProduct(){
		log.info("메인홈에서 최신 상품 조회");
		return mpMapper.selectForNewProduct();
	}

}
