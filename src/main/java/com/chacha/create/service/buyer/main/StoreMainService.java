package com.chacha.create.service.buyer.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.product.StoreProductDTO;
import com.chacha.create.common.mapper.product.StoreProductMapper;
import com.chacha.create.common.mapper.store.StoreIdCheckMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StoreMainService{
	
	@Autowired
	private StoreProductMapper storeProductMapper;
	@Autowired
	private StoreIdCheckMapper idCheckMapper;
	
	
	// 스토어에서 사용자가 상품명 검색시 조회
		public List<StoreProductDTO> selectByProductName(Map<String,Object>params){
			log.info("스토어에서 상품명으로 검색 조회 요청 : {}",params);
			return storeProductMapper.selectByProductName(params);
		}
		
		// 스토어 전체 상품 조회(조건 정렬)
			public List<StoreProductDTO> selectForProductList(Map<String,Object>params){
				log.info("스토어에서 전체상품(조건조회) 조회 요청 : {}",params);
				return storeProductMapper.selectForProductList(params);
			}
		
		
		// 해당 스토어URL의 스토어ID체크
		public int storeIdCheck(String storeUrl) {
			Integer storeId = idCheckMapper.selectByStoreUrl(storeUrl);
			log.info("스토어 URL로 스토어 ID 조회 요청 : {}",storeUrl);
			return storeId;
		}

		// 스토어의 인기상품 조회
		public List<StoreProductDTO> selectBestProduct(int storeId) {
			log.info("스토어 ID로 인기 상품 조회 요청: {}", storeId);
			return storeProductMapper.selectBestProduct(storeId);
		}

		// 스토어의 대표상품 조회
		public List<StoreProductDTO> storeMainProduct(int storeId) {
			log.info("스토어 ID로 대표 상품 조회 요청: {}", storeId);
			return storeProductMapper.storemainProduct(storeId);
		}
	

}

