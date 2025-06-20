package com.chacha.create.service.auth.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.common.mapper.member.MemberMapper;
import com.chacha.create.common.mapper.member.SellerMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegisterService {

	private final MemberMapper memberMapper;
	private final SellerMapper sellerMapper;

    @Autowired
    public RegisterService(MemberMapper memberMapper, SellerMapper sellerMapper) {
        this.memberMapper = memberMapper;
        this.sellerMapper = sellerMapper;
    }
    
    public int memberinsert(MemberEntity memberEntity) {
    	int result = memberMapper.insert(memberEntity);
    	return result;
    }
    
    public int sellerinsert(SellerEntity sellerEntity) {
    	int result = sellerMapper.insert(sellerEntity);
    	return result;
    }
    
    
}
