package com.chacha.create.controller.controller.mainhome.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// 리뷰 오류

@Slf4j
@Controller
@RequestMapping("main/mypage")
public class MainMyPageController {

    
    @GetMapping("/cart")
    public String showCartPage() {
		return "store/buyer/mypage/cart";
    }
    
    @GetMapping("/orders")
    public String showOrdersPage() {
		return "store/buyer/mypage/orderList";
    }
    
    @GetMapping("/favorite")
    public String showFavoritePage() {
		return "";
    }
    
    @GetMapping("/myreview")
    public String showReviewPage() {
		return "main/mypage/mainMyPageReview";
    }
    
    
}
