package com.chacha.create.controller.mainhome.personal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.error.ApiResponse;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.enums.error.ResponseCode;
import com.chacha.create.service.mainhome.personal.PersonalSettlementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/main/sell")
@Slf4j
public class PersonalSettlementRestController {
    
    @Autowired
    private PersonalSettlementService personalSettlementService;

    @GetMapping("/management")
    public ResponseEntity<ApiResponse<Map<String, List<?>>>> getSellManagement(HttpSession session) {
        MemberEntity member = (MemberEntity) session.getAttribute("loginMember");
        
        log.info("판매 정산 조회 요청 - memberId: {}", member.getMemberId());
        
        Map<String, List<?>> result = new HashMap<>();
        List<Map<String, Object>> sellmanageList = personalSettlementService.sellManagement(member.getMemberId());
        List<Map<String, Object>> daySellmanagelist = personalSettlementService.daySellManagement(member.getMemberId());
        
        result.put("sellmanageList", sellmanageList);
        result.put("daySellmanagelist", daySellmanagelist);
        
        return ResponseEntity.ok(new ApiResponse<>(ResponseCode.OK, result));
    }
}
