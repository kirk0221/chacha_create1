package com.chacha.create.controller.rest.store_common.header;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.error.ApiResponse;
import com.chacha.create.common.dto.member.RegisterDTO;
import com.chacha.create.common.entity.member.AddrEntity;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.common.enums.error.ResponseCode;
import com.chacha.create.service.store_common.header.auth.LoginService;
import com.chacha.create.service.store_common.header.auth.RegisterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<MemberEntity>> login(HttpSession session, @RequestBody MemberEntity member) {
        MemberEntity loginMember = loginService.login(member.getMemberEmail(), member.getMemberPwd());
        log.info(loginMember.toString());
        session.setAttribute("loginMember", loginMember);
        return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, loginMember));
    }

    @PostMapping(value = "/join/userinfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<MemberEntity>> userinfo(HttpSession session, @RequestBody RegisterDTO registerDTO) {
    	log.info(registerDTO.toString());
    	MemberEntity member = registerDTO.getMember();
    	AddrEntity addr = registerDTO.getAddr();
        MemberEntity loginMember = registerService.memberinsert(member, addr);
        session.setAttribute("loginMember", loginMember); // 바로 로그인
        return ResponseEntity.status(ResponseCode.CREATED.getStatus())
                             .body(new ApiResponse<>(ResponseCode.CREATED, loginMember));
    }

    @PostMapping(value = "/join/seller", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Integer>> seller(HttpSession session, @RequestBody SellerEntity sellerEntity) {
        MemberEntity member = (MemberEntity) session.getAttribute("loginMember");
        int result = registerService.sellerinsert(sellerEntity, member);
        return ResponseEntity.status(ResponseCode.CREATED.getStatus())
                             .body(new ApiResponse<>(ResponseCode.CREATED, result));
    }
}
