package com.chacha.create.service.mainhome.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.exception.InvalidRequestException;
import com.chacha.create.common.mapper.member.SellerMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

@Service
public class StoreService {

	private StoreMapper storeMapper;
	private SellerMapper sellerMapper;
	
	@Autowired
	public StoreService(StoreMapper storeMapper, SellerMapper sellerMapper){
		this.storeMapper = storeMapper;
		this.sellerMapper = sellerMapper;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int storeUpdate(StoreEntity storeEntity, MemberEntity memberEntity) {
		
		SellerEntity sellerEntity = sellerMapper.selectByMemberId(memberEntity.getMemberId()); // 로그인한 아이디로 seller를 가져옴
	
		
		int sellerId = sellerEntity.getSellerId();
		
		storeEntity.setSellerId(sellerId); // seller 아이디로 스토어 정보를 추가 
		storeEntity.setStoreId(storeMapper.selectBySellerId(sellerId).getStoreId()); // seller 아이디로 스토어 아이디를 찾기
		
		if(sellerEntity.getPersonalCheck() == 0 && storeEntity.getStoreUrl()!=null) {
			throw new InvalidRequestException("판매자는 스토어를 하나만 생성할 수 있습니다.");
		}else if(sellerEntity.getPersonalCheck() == 0 && storeEntity.getStoreUrl()==null) {
			throw new InvalidRequestException("개인판매자 등록을 먼저 해야됩니다.");
		}
		
		sellerMapper.updateBypersonalCheck(sellerId, 0);
		
		return storeMapper.update(storeEntity); // 정보 업데이트
	}
	
	public List<StoreEntity> selectAll() {
		return storeMapper.selectAll();
	}
	
}
