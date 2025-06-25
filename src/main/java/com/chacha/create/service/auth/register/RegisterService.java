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
        try {
            String password = memberEntity.getMemberPwd();
            String email = memberEntity.getMemberEmail();
            String phone = memberEntity.getMemberPhone();
            String regi = memberEntity.getMemberRegi();

            // 유효성 검사
            if (!isValidPassword(password)) {
                log.info("비밀번호 형식 오류");
                return null;
            }
            if (!isValidEmail(email)) {
                log.info("이메일 형식 오류");
                return null;
            }
            if (!isValidPhoneNumber(phone)) {
                log.info("전화번호 형식 오류");
                return null;
            }
            if (!isValidRegi(regi)) {
                log.info("주민등록번호 형식 오류");
                return null;
            }

            memberMapper.insert(memberEntity);
            member = memberMapper.selectByMemberEmail(memberEntity.getMemberEmail());
        } catch(Exception e) {
            log.info("아이디가 중복됨 : " + e.getMessage());
            return null;
        }
        return member;
    }

    private boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) return false;

        String specialChars = "!\"#$%&'()*+,-./:;<=>?@\\[₩\\]^_`{|}~";
        boolean hasLetter = password.matches(".*[a-zA-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[" + specialChars + "].*");

        return hasLetter && hasDigit && hasSpecial;
    }
    
    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }

    private boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("^01[016789]-\\d{3,4}-\\d{4}$");
    }

    private boolean isValidRegi(String regi) {
        return regi != null && regi.matches("^\\d{6}-[1-4]{1}$");
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
