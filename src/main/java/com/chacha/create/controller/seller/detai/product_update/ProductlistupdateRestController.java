package com.chacha.create.controller.seller.detai.product_update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.ProductUpdateDTO;
import com.chacha.create.service.seller.update.ProductUpdateService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/{storeUrl}/seller/productupdate")
@Slf4j
public class ProductlistupdateRestController {

	@Autowired
	ProductUpdateService productUpdateService;
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductUpdateDTO> getProductDetail(
	        @PathVariable("storeUrl") String storeUrl,
	        @PathVariable("productId") int productId) {

	    ProductUpdateDTO product = productUpdateService.getProductDetail(storeUrl, productId);

	    if (product != null) {
	        return ResponseEntity.ok(product);
	    } else {
	        return ResponseEntity.noContent().build();
	    }
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<Void> updateProductDetail(
	        @PathVariable("storeUrl") String storeUrl,
	        @PathVariable("productId") int productId,
	        @RequestBody ProductUpdateDTO productUpdateDTO) {

	    productUpdateDTO.setProductId(productId);

	    if (productUpdateDTO.getPimgUrl1() == null) productUpdateDTO.setPimgUrl1("");
	    if (productUpdateDTO.getPimgUrl2() == null) productUpdateDTO.setPimgUrl2("");
	    if (productUpdateDTO.getPimgUrl3() == null) productUpdateDTO.setPimgUrl3("");

	    boolean updated = productUpdateService.updateProductDetail(storeUrl, productUpdateDTO);
	    return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
	
	
}
