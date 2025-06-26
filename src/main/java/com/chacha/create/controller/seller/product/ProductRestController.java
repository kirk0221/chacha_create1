package com.chacha.create.controller.seller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.ProductUpdateDTO;
import com.chacha.create.common.dto.product.ProductWithImagesDTO;
import com.chacha.create.common.dto.product.ProductlistDTO;
import com.chacha.create.common.entity.product.ProductEntity;
import com.chacha.create.service.seller.product.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/{storeUrl}/seller")
@Slf4j
public class ProductRestController {

    @Autowired
    private ProductService productService;

    // 상품 리스트 조회
    @GetMapping(value="/productlist")
    public List<ProductlistDTO> productlistjoin(@PathVariable String storeUrl) {
        return productService.productAllListByStoreUrl(storeUrl);
    }

    // 대표 상품 수정
    @PutMapping(value="/productlist", consumes = MediaType.APPLICATION_JSON_VALUE)
    public int updateFlagship(@PathVariable String storeUrl, @RequestBody List<ProductlistDTO> dtoList) {
        return productService.updateFlagship(storeUrl, dtoList);
    }

    // 상품 삭제 (논리 삭제)
    @DeleteMapping(value = "/productlist", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public int deleteFlagshipBatch(@RequestBody List<ProductEntity> productList) {
        return productService.productDeleteByEntities(productList);
    }
    
    // 상품 입력
    @PostMapping(value = "/productinsert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertProductWithImages(@PathVariable("storeUrl") String storeUrl,
                                       @RequestBody ProductWithImagesDTO request) {
        return productService.registerProductWithImages(storeUrl, request);
    }

    
	@GetMapping("/productupdate/{productId}")
	public ResponseEntity<ProductUpdateDTO> getProductDetail(
	        @PathVariable("storeUrl") String storeUrl,
	        @PathVariable("productId") int productId) {

	    ProductUpdateDTO product = productService.getProductDetail(storeUrl, productId);

	    if (product != null) {
	        return ResponseEntity.ok(product);
	    } else {
	        return ResponseEntity.noContent().build();
	    }
	}
	
	@PutMapping("/productupdate/{productId}")
	public int updateProductDetail(
	        @PathVariable("storeUrl") String storeUrl,
	        @PathVariable("productId") int productId,
	        @RequestBody ProductUpdateDTO productUpdateDTO) {

	    productUpdateDTO.setProductId(productId);

	    if (productUpdateDTO.getPimgUrl1() == null) productUpdateDTO.setPimgUrl1("");
	    if (productUpdateDTO.getPimgUrl2() == null) productUpdateDTO.setPimgUrl2("");
	    if (productUpdateDTO.getPimgUrl3() == null) productUpdateDTO.setPimgUrl3("");

	    boolean updated = productService.updateProductDetail(storeUrl, productUpdateDTO);

	    if (updated) {
	    	log.info("update 성공");
	        return 1;
	    } else {
	    	log.info("update 실패");
	        return 0;
	    }
	}
}