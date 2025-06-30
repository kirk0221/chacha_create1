package com.chacha.create.controller.seller.shut_down;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.error.ApiResponse;
import com.chacha.create.common.dto.manager.StoreManagerUpdateDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.enums.error.ResponseCode;
import com.chacha.create.service.manager.store.StoreManagementUpdateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/{storeUrl}/seller")
public class StoreManagementUpdateController {

    @Autowired
    private StoreManagementUpdateService storeService;

    @PostMapping("/management/sellerInfo")
    public ResponseEntity<ApiResponse<Void>> updateStoreAndSeller(
            @PathVariable("storeUrl") String storeUrl,
            HttpSession session,
            @RequestBody StoreManagerUpdateDTO smuDTO) {

        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        if (loginMember == null) {
            return ResponseEntity.status(ResponseCode.UNAUTHORIZED.getStatus())
                    .body(new ApiResponse<>(ResponseCode.UNAUTHORIZED, ResponseCode.UNAUTHORIZED.getMessage()));
        }

        int result = storeService.sellerInfoUpdate(loginMember, storeUrl, smuDTO);

        if (result < 3) {
            // 변경사항 없음 -> 204 No Content로 응답해도 되지만 메시지 남기려면 OK에 메시지 포함
            return ResponseEntity.ok(new ApiResponse<>(ResponseCode.NO_CONTENT, "변경된 정보가 없습니다."));
        } else {
            return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, "정보가 성공적으로 수정되었습니다."));
        }
    }
}
