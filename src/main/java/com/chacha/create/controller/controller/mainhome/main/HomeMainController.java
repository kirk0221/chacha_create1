package com.chacha.create.controller.controller.mainhome.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/main")
public class HomeMainController {
	
	// 변경해주세요
	@GetMapping("/test")
	public String showTestPage() {
		return "store/seller/sellerOrderManage";
	}
	
    // 메인 홈 페이지
    @GetMapping
    public String showMainHome() {
        return "main/main"; 
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
    
    @GetMapping("/order")
    public String showOrderPage() {
    	return "main/mypage/mainorder";
    }
 
}
