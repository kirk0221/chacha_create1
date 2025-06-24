package com.chacha.create.controller.buyer.detail;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.order.ReviewEntity;
import com.chacha.create.service.buyer.detail.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/main/productdetail/{productId}/review")
public class ProductReviewController {
	
	@Autowired
    private ReviewService reviewService;
    
    // 리뷰 작성 가능 여부를 체크하는 함수(프론트 연결 시 필요)
    @GetMapping("/check")
    public boolean isReviewWritable(@RequestParam int orderDetailId, HttpSession session) {
    	MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
    			if (loginMember == null) {
    	            return false;
    	        }
    	        int memberId = loginMember.getMemberId();
    	        return reviewService.selectForCheckReview(orderDetailId, memberId);
    }
    
    // 주문 상세별 자신의 리뷰 조회(수정 및 삭제 시 리뷰 불러오는 용도)
    @GetMapping("/orderdetail/{orderDetailId}")
    public ReviewEntity getReviewByOrderDetail(@PathVariable int orderDetailId) {
        return reviewService.selectByOrderDetailId(orderDetailId);
    }

    @GetMapping
    public List<ReviewEntity> getReviewsByProduct(@PathVariable int productId,
                                                  @RequestParam(required = false) Integer memberId) {
        return reviewService.selectByProductId(productId, memberId);
    }

    @PostMapping
    public String addReview(@RequestBody ReviewEntity review, HttpSession session) {
        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        if (loginMember == null) {
        	return "로그인이 필요";
        }
        int result = reviewService.insert(review, loginMember.getMemberId());
        
        return result > 0 ? "등록 성공" : "등록 실패";
    }

    @PutMapping
    public String updateReview(@RequestBody ReviewEntity review, HttpSession session) {
    	MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        if (loginMember == null) {
        	return "로그인이 필요";
        }
        int memberId = loginMember.getMemberId();
        int result = reviewService.update(review, memberId);
        
        return result > 0 ? "수정 성공" : "수정 실패";
    }

    @DeleteMapping
    public String deleteReview(@RequestParam int reviewId, HttpSession session) {
    	MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        if (loginMember == null) {
        	return "로그인이 필요";
        }
        int memberId = loginMember.getMemberId();
        int result = reviewService.delete(reviewId, memberId);

        return result > 0 ? "삭제 성공" : "삭제 실패";
    }
}