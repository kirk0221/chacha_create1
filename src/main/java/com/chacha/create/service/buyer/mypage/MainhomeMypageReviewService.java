package com.chacha.create.service.buyer.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.order.ReviewEntity;
import com.chacha.create.common.mapper.order.ReviewMapper;

@Service
public class MainhomeMypageReviewService {
	
	private final ReviewMapper reviewMapper;
	
	@Autowired
	public MainhomeMypageReviewService(ReviewMapper reviewMappepr) {
		this.reviewMapper = reviewMappepr;
	}
	
	public List<ReviewEntity> selectAllReviews(){
		return reviewMapper.selectAll();
	}
	
	
	public ReviewEntity selectReviewById(int reviewId) {
        return reviewMapper.selectById(reviewId);
    }
	
	
	public List<ReviewEntity> selectByMemberId(int memberId) {
		return reviewMapper.selectByMemberId(memberId);
	}
	

}
