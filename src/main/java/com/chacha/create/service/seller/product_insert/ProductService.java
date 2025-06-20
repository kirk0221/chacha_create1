package com.chacha.create.service.seller.product_insert;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.product.PImgEntity;
import com.chacha.create.common.entity.product.ProductEntity;
import com.chacha.create.common.mapper.product.PImgMapper;
import com.chacha.create.common.mapper.product.ProductMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
	
	private final PImgMapper pimgMapper;
	private final ProductMapper productMapper;

	public int productimgInsert(PImgEntity p_imge) {
		pimgMapper.insert(p_imge);
		return 0;
	}

	public int productInsert(ProductEntity product) {
		productMapper.insert(product);
		return 0;
	}
	
	public List<ProductEntity> productlist(){
		return productMapper.selectAll();
	}
}
