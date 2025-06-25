package com.chacha.create.service.manager.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.mapper.member.MemberMapper;
import com.chacha.create.common.mapper.member.SellerMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StoreManagementUpdateService {
	
	private StoreMapper storeMapper;
    private SellerMapper sellerMapper;
    private MemberMapper memberMapper;

    @Autowired
    public StoreManagementUpdateService(StoreMapper storeMapper, 
                                  SellerMapper sellerMapper, MemberMapper memberMapper) {
        this.storeMapper = storeMapper;
        this.sellerMapper = sellerMapper;
        this.memberMapper = memberMapper;
    }
		
	    public int storeupdate(StoreEntity storeEntity) {
	    		log.info("store update 진입");
	        return storeMapper.updateStoreInfo(storeEntity);
		}
		public int sellerupdate(SellerEntity sellerEntity) {
			log.info("seller update 진입");
			return sellerMapper.updateSellerInfo(sellerEntity);
		}
		public int memberupdate(MemberEntity memberEntity) {
			log.info("member update 진입");
			return memberMapper.updateMemberInfo(memberEntity);
		}

}
