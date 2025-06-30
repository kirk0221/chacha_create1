package com.chacha.create.controller.store_common.mypage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.error.ApiResponse;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.enums.error.ResponseCode;
import com.chacha.create.service.store_common.mypage.MyInfoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/{storeUrl}/mypage")
public class MyInfoRestController {

    @Autowired
    private MyInfoService myInfoService;
    
    // 회원 정보 수정
    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<String>> mypageUpdate(HttpSession session) {
        MemberEntity member = (MemberEntity) session.getAttribute("loginMember");

        if (member == null) {
            return ResponseEntity.status(ResponseCode.UNAUTHORIZED.getStatus())
                                 .body(new ApiResponse<>(ResponseCode.UNAUTHORIZED, null));
        }

        int result = myInfoService.memberupdate(member);

        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, "회원 정보 수정 완료"));
        } else {
            return ResponseEntity.status(ResponseCode.BAD_REQUEST.getStatus())
                                 .body(new ApiResponse<>(ResponseCode.BAD_REQUEST, "회원 정보 수정 실패"));
        }
    }

    // 회원 탈퇴
    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<String>> mypageDelete(HttpSession session) {
        MemberEntity member = (MemberEntity) session.getAttribute("loginMember");

        if (member == null) {
            return ResponseEntity.status(ResponseCode.UNAUTHORIZED.getStatus())
                                 .body(new ApiResponse<>(ResponseCode.UNAUTHORIZED, null));
        }

        int result = myInfoService.memberdelete(member.getMemberId());

        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, "회원 탈퇴 완료"));
        } else {
            return ResponseEntity.status(ResponseCode.BAD_REQUEST.getStatus())
                                 .body(new ApiResponse<>(ResponseCode.BAD_REQUEST, "회원 탈퇴 실패"));
        }
    }
}

