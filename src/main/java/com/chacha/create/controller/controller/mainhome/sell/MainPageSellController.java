package com.chacha.create.controller.controller.mainhome.sell;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/main/sell")
public class MainPageSellController {

    
	// 개인 판매 홈 ( /main/sell )
    @GetMapping("sellguide")
    public String personalSellHome() {
        return "main/personal/storeInfo";
    }

    // 개인 판매 상품 등록 ( /main/personalsell/register )
    @GetMapping("/sellregister")
    public String productRegister() {
        return "main/personal/saleRegistration";
    }

    // 개인 판매 상품 목록 ( /main/personalsell/products )
    @GetMapping("/products")
    public String productList() {
        return "main/personal/orderManage";
    }

    // 개인 판매 정산 페이지 ( /main/personalsell/settlement )
    @GetMapping("/management")
    public String settlementPage() {
        return "main/personal/personalSettlement";
    }
}
