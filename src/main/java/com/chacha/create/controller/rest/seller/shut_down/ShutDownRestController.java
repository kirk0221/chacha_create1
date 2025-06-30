package com.chacha.create.controller.rest.seller.shut_down;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.error.ApiResponse;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.enums.error.ResponseCode;
import com.chacha.create.service.seller.shut_down.ShutDownService;
import com.chacha.create.service.store_common.header.auth.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/{storeUrl}/seller")
public class ShutDownRestController {

    @Autowired
    private ShutDownService shutDownService;

    @Autowired
    private LoginService loginService;

    @PutMapping(value = "/close", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Integer>> close(
            HttpSession session,
            @PathVariable("storeUrl") String storeUrl,
            @RequestBody MemberEntity memberEntity) {

        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        MemberEntity member = loginService.login(memberEntity.getMemberEmail(), memberEntity.getMemberPwd());

        if (member != null && member.equals(loginMember)) {
            try {
                int result = shutDownService.shutdown(storeUrl);
                if (result > 0) {
                    return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, result));
                } else {
                    // 실패 시엔 409 Conflict 등 적절한 상태코드로 응답하는게 좋아요
                    return ResponseEntity.status(ResponseCode.CONFLICT.getStatus())
                            .body(new ApiResponse<>(ResponseCode.CONFLICT, 0));
                }
            } catch (IllegalStateException e) {
                log.error("상점 종료 중 오류 발생", e);
                return ResponseEntity.status(ResponseCode.INTERNAL_SERVER_ERROR.getStatus())
                        .body(new ApiResponse<>(ResponseCode.INTERNAL_SERVER_ERROR, 0));
            }
        } else {
            return ResponseEntity.status(ResponseCode.UNAUTHORIZED.getStatus())
                    .body(new ApiResponse<>(ResponseCode.UNAUTHORIZED, 0));
        }
    }
}
