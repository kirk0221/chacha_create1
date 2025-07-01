package com.chacha.create.controller.controller.mainhome.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("main/mypage")
public class MainMyPageController {

    
    @GetMapping("/cart")
    public String showCartPage() {
		return "buyer/mypage/cart";
    }
    
    @GetMapping("/orders")
    public String showOrdersPage() {
		return "main/main_mypage_order_detail";
    }
    
    @GetMapping("/favorite")
    public String showFavoritePage() {
		return "";
    }
    
    @GetMapping("/myreview")
    public String showReviewPage() {
		return "main/main_mypage_review";
    }
    
    
}
