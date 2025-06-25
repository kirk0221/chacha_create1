package com.chacha.create.controller.seller.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chacha.create.common.dto.product.ReviewManagementDTO;
import com.chacha.create.service.buyer.detail.ReviewService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/{storeUrl}/seller")
@Slf4j
public class ReviewManagementController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviewlist")
    public List<ReviewManagementDTO> getReviewList(@PathVariable("storeUrl") String storeUrl) {
        log.info("리뷰 목록 조회 요청 - storeUrl: {}", storeUrl);
        return reviewService.selectAllMyReview(storeUrl);
    }
}