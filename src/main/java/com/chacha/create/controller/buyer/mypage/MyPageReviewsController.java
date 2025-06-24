package com.chacha.create.controller.buyer.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.order.ReviewEntity;
import com.chacha.create.service.buyer.detail.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/main/mypage")
public class MyPageReviewsController {

    @Autowired
    private ReviewService reviewService;
    
    // 리뷰 ID로 조회 (GET 방식) - 단건 조회
    @GetMapping(value = "/reviewById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReviewEntity getReviewById(@RequestParam int reviewId) {
        return reviewService.selectByReviewId(reviewId);
    }
    
    // 회원 ID로 조회 - 내 리뷰 전체 조회
    @GetMapping(value = "/reviewmemberById", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReviewEntity> getmemberId(HttpSession session) {
    	MemberEntity member= (MemberEntity) session.getAttribute("loginMember");
    	return reviewService.selectByMemberId(member.getMemberId());
    };
     
}