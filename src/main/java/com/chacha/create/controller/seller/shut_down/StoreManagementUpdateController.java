package com.chacha.create.controller.seller.shut_down;

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
@RequestMapping("/api/{storeUrl}")
public class StoreManagementUpdateController {
	
	@Autowired
	StoreManagementUpdateService storeService;
	
	@PostMapping("/management/sellerInfo")
	public ResponseEntity<?> updateStoreAndSeller(@PathVariable("storeUrl") String storeUrl,
			HttpSession session, @RequestBody StoreManagerUpdateDTO smuDTO) {
		// 로그인된 사용자 세션으로 memberID등록
		MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");

		int result = storeService.sellerInfoUpdate(loginMember, storeUrl, smuDTO);

		if (result<3) {
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
