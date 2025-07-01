package com.chacha.create.controller.controller.mainhome.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/main")
public class HomeMainController {

    // 메인 홈 페이지
    @GetMapping("/home")
    public String showMainHome() {
        return "main/main"; // /WEB-INF/views/main/main_test.jsp
    }

    // 회원가입 페이지 연결
    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup"; 
    }
    
    
    @GetMapping("/products")
    public String showAllproductsPage() {
		return "main/main_all_products";
    }
    
    
    @GetMapping("/question")
    public String showNoticePage() {
		return "main/main_notice";
    }
    
    
    @GetMapping("/mypage")
    public String showMyPage() {
    	return "main/main_mypage_correction";
    }
    
 
}
