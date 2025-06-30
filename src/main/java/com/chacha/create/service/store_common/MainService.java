package com.chacha.create.service.store_common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.product.HomeProductDTO;
import com.chacha.create.common.mapper.product.MainPageMapper;
import com.chacha.create.common.mapper.product.PImgMapper;
import com.chacha.create.common.mapper.product.ProductManageMapper;
import com.chacha.create.common.mapper.store.StoreIdCheckMapper;
import com.chacha.create.util.ServiceUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {

    private final MainPageMapper mainPageMapper;
    private final StoreIdCheckMapper idCheckMapper;

    /** 🛍️ 스토어 메인 페이지 - 인기 + 대표 상품 묶음 */
    public Map<String, List<HomeProductDTO>> getStoreMainProductMap(int storeId) {
        return Map.of(
            "bestProduct", mainPageMapper.selectForBestProduct(storeId),
            "mainProduct", mainPageMapper.selectForStoreMainProduct(storeId)
        );
    }

    /** 🏠 메인 홈 - 인기 스토어 + 인기 상품 + 신상품 */
    public Map<String, Object> getHomeMainProductMap() {
        return Map.of(
            "bestStore", mainPageMapper.selectForBestStore(),
            "bestProduct", mainPageMapper.selectForBestProduct(null),
            "newProduct", mainPageMapper.selectForNewProduct()
        );
    }

    /** 🔍 필터/검색 조건 기반 상품 리스트 조회 */
    public List<HomeProductDTO> getFilteredProductListWithParams(
            Integer storeId,
            List<String> type,
            List<String> d,
            List<String> u,
            String keyword,
            String sort) {

        Map<String, Object> params = new HashMap<>();
        if (storeId != null) params.put("storeId", storeId);
        params.put("sort", (sort != null && !sort.isEmpty()) ? sort : "latest");
        params.put("keyword", keyword);

        ServiceUtil.putParsedParam(params, "type", type);
        ServiceUtil.putParsedParam(params, "d", d);
        ServiceUtil.putParsedParam(params, "u", u);

        if (keyword != null && !keyword.isEmpty()) {
            log.info("🔍 상품명 검색 요청: {}", keyword);
            return mainPageMapper.selectByProductName(keyword);
        }

        log.info("🔍 조건 기반 상품 조회 요청: {}", params);
        return mainPageMapper.selectForProductList(params);
    }

    /** 📌 스토어 URL → 스토어 ID 확인 */
    public int storeIdCheck(String storeUrl) {
        return idCheckMapper.selectByStoreUrl(storeUrl);
    }
}
