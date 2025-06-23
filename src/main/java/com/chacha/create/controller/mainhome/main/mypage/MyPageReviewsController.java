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

@RestController
@Slf4j
@RequestMapping("/main/mypage")
public class MyPageReviewsController {

    @Autowired
    private MainhomeMypageReviewService mainhomeMypageService;

    // 전체 리뷰 조회 (POST 방식)
    @PostMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReviewEntity> getAllReviews() {
        return mainhomeMypageService.selectAllReviews();
    }
    
    // 리뷰 ID로 조회 (GET 방식)
    @GetMapping(value = "/reviewById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReviewEntity getReviewById(@RequestParam int reviewId) {
        return mainhomeMypageService.selectReviewById(reviewId);
    }
    
    @GetMapping(value = "/reviewmemberById", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReviewEntity> getmemberId(HttpSession session) {
    	MemberEntity member= (MemberEntity) session.getAttribute("loginMember");
    	return mainhomeMypageService.selectByMemberId(member.getMemberId());
    };
     
}













