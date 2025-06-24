package com.chacha.create.service.auth.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.mapper.member.MemberMapper;
import com.chacha.create.common.mapper.member.SellerMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegisterService {

	private final MemberMapper memberMapper;
	private final SellerMapper sellerMapper;
	private final StoreMapper storeMapper;

    @Autowired
    public RegisterService(MemberMapper memberMapper, SellerMapper sellerMapper, StoreMapper storeMapper) {
        this.memberMapper = memberMapper;
        this.sellerMapper = sellerMapper;
        this.storeMapper = storeMapper;
    }
    
    @Transactional(rollbackFor = Exception.class)
    public MemberEntity memberinsert(MemberEntity memberEntity) {
    	MemberEntity member = null;
    	try{
    		memberMapper.insert(memberEntity);
    		member = memberMapper.selectByMemberEmail(memberEntity.getMemberEmail());
    	}catch(Exception e) {
    		log.info("아이디가 중복됨 : " + e.getMessage());
    	}
    	return member;
    }
    
    @Transactional(rollbackFor = Exception.class)
    public int sellerinsert(SellerEntity sellerEntity, MemberEntity memberEntity) {
    	int result = 0;
    	sellerEntity.setMemberId(memberEntity.getMemberId());
    	sellerMapper.insert(sellerEntity);
    	SellerEntity seller = sellerMapper.selectByMemberId(memberEntity.getMemberId());
    	StoreEntity storeEntity = StoreEntity.builder()
    			.sellerId(seller.getSellerId())
    			.build();
    	result = storeMapper.insert(storeEntity);
    	return result;
    }
}
