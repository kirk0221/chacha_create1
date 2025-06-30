package com.chacha.create.controller.controller.auth.join;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {

    // 메인 홈 페이지
    @GetMapping("/login")
    public String showMainHome() {
        return "login"; // /WEB-INF/views/main/main_test.jsp
    }

    
}
