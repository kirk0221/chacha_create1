package com.chacha.create.controller.mainhome.main.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.order.ReviewEntity;
import com.chacha.create.service.buyer.mypage.MainhomeMypageReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/main/mypage")
public class MyPageReviewsController {

    @Autowired
    private MainhomeMypageReviewService mainhomeMypageService;
    
    // 리뷰 ID로 조회 (GET 방식) - 단건 조회
    @GetMapping(value = "/reviewById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReviewEntity getReviewById(@RequestParam int reviewId) {
        return mainhomeMypageService.selectReviewById(reviewId);
    }
    
    // 회원 ID로 조회 - 내 리뷰 전체 조회
    @GetMapping(value = "/reviewmemberById", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReviewEntity> getmemberId(HttpSession session) {
    	MemberEntity member= (MemberEntity) session.getAttribute("loginMember");
    	return mainhomeMypageService.selectByMemberId(member.getMemberId());
    };
     
}













