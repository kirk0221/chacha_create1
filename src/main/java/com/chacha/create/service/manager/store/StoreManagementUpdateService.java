package com.chacha.create.service.manager.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.dto.manager.StoreManagerUpdateDTO;
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
	
    @Transactional(rollbackFor = Exception.class)
	public int sellerInfoUpdate(MemberEntity loginMember, String storeUrl, StoreManagerUpdateDTO smuDTO) {
		int result = 0;
		StoreEntity userStore = storeMapper.selectByStoreUrl(storeUrl);
		StoreEntity storeEntity = StoreEntity.builder()
				.storeId(userStore.getStoreId())
				.logoImg(smuDTO.getLogoImg())
				.storeName(smuDTO.getStoreName())
				.storeDetail(smuDTO.getStoreDetail())
				.build();
		
		SellerEntity sellerEntity = SellerEntity.builder()
				.sellerId(userStore.getSellerId())
				.account(smuDTO.getAccount())
				.accountBank(smuDTO.getAccountBank())
				.profileInfo(smuDTO.getProfileInfo())
				.build();
		
		MemberEntity memberEntity = MemberEntity.builder()
				.memberId(loginMember.getMemberId())
				.memberPwd(smuDTO.getMemberPwd())
				.memberPhone(smuDTO.getMemberPhone())
				.build();
		
		log.info("최종값store : {}", memberEntity);
		log.info("최종값seller : {}", storeEntity);
		log.info("최종값member : {}", sellerEntity);
		
		result += storeMapper.updateStoreInfo(storeEntity);
		result += sellerMapper.updateSellerInfo(sellerEntity);
		result += memberMapper.updateMemberInfo(memberEntity);
		
		return result;
	}

}
