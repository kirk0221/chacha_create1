package com.chacha.create.controller.controller.mainhome.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// signup 크기 오류, products, mypage 오류

@Slf4j
@Controller
@RequestMapping("/main")
public class HomeMainController {
	
	@GetMapping("/test")
	public String showTestPage() {
		return"seller_management_order";
	}
    // 메인 홈 페이지
    @GetMapping("/home")
    public String showMainHome() {
        return "main/main"; // /WEB-INF/views/main/main_test.jsp
    }

    // 회원가입 페이지 연결
    @GetMapping("/signup")
    public String showSignupPage() {
        return "auth/signUp"; 
    }
    
    
    @GetMapping("/products")
    public String showAllproductsPage() {
		return "main/mainAllProducts";
    }
    
    
    @GetMapping("/question")
    public String showNoticePage() {
		return "main/mainNotice";
    }
    
    
    @GetMapping("/mypage")
    public String showMyPage() {
    	return "main/mypage/mainMyPage";
    }
 
}
