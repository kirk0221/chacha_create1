package com.chacha.create.controller.controller.mainhome.mypage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "main/mypage/mainMyPageCart";
    }
    
    @GetMapping("/orders")
    public String showOrdersPage() {
		return "main/mypage/mainMyPageOrderList";
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
