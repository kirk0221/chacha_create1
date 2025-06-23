package com.chacha.create.service.mainhome.store_create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.mapper.member.SellerMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

@Service
public class StoreCreateService {

	private StoreMapper storeMapper;
	private SellerMapper sellerMapper;
	
	@Autowired
	public StoreCreateService(StoreMapper storeMapper, SellerMapper sellerMapper){
		this.storeMapper = storeMapper;
		this.sellerMapper = sellerMapper;
	}
	
	public int storeInsert(StoreEntity storeEntity, MemberEntity memberEntity) {
		
		SellerEntity sellerEntity = sellerMapper.selectByMemberId(memberEntity.getMemberId());
		
		storeEntity.setSellerId(sellerEntity.getSellerId());
		
		return storeMapper.insert(storeEntity);
	}
	
}
