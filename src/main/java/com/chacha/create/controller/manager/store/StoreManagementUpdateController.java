package com.chacha.create.controller.manager.store;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.manager.StoreManagerUpdateDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.service.manager.store.StoreManagementUpdateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/{storeUrl}")
public class StoreManagementUpdateController {
	
	@Autowired
	StoreManagementUpdateService storeService;
	
	@PostMapping("/seller/management")
	public ResponseEntity<?> updateStoreAndSeller(@PathVariable("storeUrl") String storeUrl,
			HttpSession session, @RequestBody StoreManagerUpdateDTO smuDTO) {
		
		StoreEntity storeEntity = new StoreEntity();
		SellerEntity sellerEntity = new SellerEntity();
		MemberEntity memberEntity = new MemberEntity();
		
		// 로그인된 사용자 세션으로 memberID등록
		MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
		memberEntity.setMemberId(loginMember.getMemberId());
		memberEntity.setMemberPwd(smuDTO.getMemberPwd());
		memberEntity.setMemberPhone(smuDTO.getMemberPhone());
		
		
		storeEntity.setLogoImg(smuDTO.getLogoImg());
		storeEntity.setStoreName(smuDTO.getStoreName());
		storeEntity.setStoreDetail(smuDTO.getStoreDetail());
		storeEntity.setStoreId(Integer.valueOf(smuDTO.getStoreId()));
		
		sellerEntity.setAccount(smuDTO.getAccount());
		sellerEntity.setAccountBank(smuDTO.getAccountBank());
		sellerEntity.setProfileInfo(smuDTO.getProfileInfo());
		sellerEntity.setSellerId(Integer.valueOf(smuDTO.getSellerId()));
		
		
		
		int storeResult = storeService.storeupdate(storeEntity);
		int sellerResult = storeService.sellerupdate(sellerEntity);
		int memberResult = storeService.memberupdate(memberEntity);
		log.info("최종값store : {}", memberEntity);
		log.info("최종값seller : {}", storeEntity);
		log.info("최종값member : {}", sellerEntity);

		
		if (storeResult == 0 && sellerResult == 0 && memberResult == 0) {
		    return ResponseEntity.ok(new ApiResponse("noChange", "변경된 정보가 없습니다."));
		} else {
		    return ResponseEntity.ok(new ApiResponse("success", "정보가 성공적으로 수정되었습니다."));
		}


	}
	
	// 응답 클래스
    static class ApiResponse {
        private String result;
        private String message;

        public ApiResponse(String result, String message) {
            this.result = result;
            this.message = message;
        }

        public String getResult() { return result; }
        public String getMessage() { return message; }
    }


}
