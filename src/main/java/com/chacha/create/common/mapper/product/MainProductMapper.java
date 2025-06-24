package com.chacha.create.common.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.chacha.create.common.dto.product.MainProductDTO;

@Mapper
public interface MainProductMapper {

	public int insertmainProduct(MainProductDTO dto);

	public int insertMainProductImage1(MainProductDTO dto);

	public int insertMainProductImage2(MainProductDTO dto);

	public int insertMainProductImage3(MainProductDTO dto);

	public Integer selectStoreIdBySellerId(int sellerId);

	public List<MainProductDTO> selectProductsByStoreId(Integer storeId);
	
	public int updateMainProduct(MainProductDTO dto);

    public int updateMainProductImage1(MainProductDTO dto);
    
    public int updateMainProductImage2(MainProductDTO dto);
    
    public int updateMainProductImage3(MainProductDTO dto);
    
    int deleteMainProductById(@Param("productId") int productId);
    
    // 해당 productId가 sellerId, storeId와 연관된지 여부 반환 (0=아님, 1=맞음)
    public int checkProductBelongsToSellerStore(
    	    @Param("productId") int productId,
    	    @Param("sellerId") int sellerId,
    	    @Param("storeId") int storeId);
}