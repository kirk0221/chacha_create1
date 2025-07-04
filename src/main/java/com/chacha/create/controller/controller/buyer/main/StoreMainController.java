package com.chacha.create.controller.controller.buyer.main;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chacha.create.common.dto.member.SellerInfoDTO;
import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.service.buyer.storeinfo.StoreInfoService;
import com.chacha.create.service.mainhome.store.StoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/{storeUrl}")
public class StoreMainController {
	
	@Autowired
	private StoreInfoService storeinfo;
	
	@Autowired
	private StoreService storeService;
	
	// 스토어 구매자 메인페이지
	@GetMapping
	public String ShowstoreMain(@PathVariable String storeUrl, Model model) {
		if(!storeService.existsByStoreUrl(storeUrl)) {
			return "redirect:/main";
		}
		model.addAttribute("storeUrl",storeUrl);
		return "store/storeMain";
	}
	
	// 구매자 마이페이지(구매자)
	@GetMapping("/mypage")
	public String ShowMypage(@PathVariable String storeUrl, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		return "store/buyer/mypage/storeMypage";
	}
	
	// 상세페이지
	@GetMapping("/productdetail/{productId}")
	public String ShowProductdetail(@PathVariable String storeUrl, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		return "store/productDetail";
	}
	
	// 장바구니 페이지
	@GetMapping("/mypage/cart")
	public String ShowCart(@PathVariable String storeUrl, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		return "store/buyer/mypage/cart";
	}
	
	// 결제 페이지
	@GetMapping("/order")
	public String ShowOrder(@PathVariable String storeUrl, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		return "store/buyer/order";
	}
	
	// 결제 완료페이지
	@GetMapping("/order/complete/{orderId}")
	public String ShowOrderComplete(@PathVariable String storeUrl, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		return "store/buyer/orderComplete";
	}
	
	// 주문 내역 페이지
	@GetMapping("/mypage/orders")
	public String ShowMyOrders(@PathVariable String storeUrl, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		return "store/buyer/mypage/orderList";
	}
	
	
	// 주문 상세 페이지
	@GetMapping("/mypage/orderdetail/{orderId}")
	public String ShowOrderDetail(@PathVariable String storeUrl, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		return "store/buyer/mypage/orderDetail";
	}
	
	// 전체 상품
	@GetMapping("/products")
	public String ShowstoreAllProduct(@PathVariable String storeUrl, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		return "store/storeAllProducts";
	}
	
	// 문의 메시지
	@GetMapping("/message")
	public String ShowMessage(@PathVariable String storeUrl, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		return "store/chat";
	}
	
	// 작성한 리뷰 확인
	@GetMapping("/mypage/myreview")
	public String ShowMyReview(@PathVariable String storeUrl, @RequestParam int productId, Model model) {
		model.addAttribute("productId",productId);
		return "store/productDetail";
	}
	
	// 스토어 소개/판매자 정보
	//{storeUrl}/info
	//{storeUrl}/info?storeUrl=aa
	@GetMapping("/info")

	public String ShowSeller_info(@PathVariable("storeUrl") String storeUrl, Model model) {
		
		List<StoreEntity> storeInfoList = storeinfo.selectByStoreInfo(storeUrl);
        List<SellerInfoDTO> sellerInfoList = storeinfo.selectBySellerInfo(storeUrl);
        
        
        if (storeInfoList != null && !storeInfoList.isEmpty()) {
            model.addAttribute("storeInfoList", storeInfoList.get(0));
        }

        if (sellerInfoList != null && !sellerInfoList.isEmpty()) {
            model.addAttribute("sellerInfoList", sellerInfoList.get(0));
        }
        
		return "store/sellerInfo";
	}
	
	// 공지사항
	@GetMapping("/notices")
	public String ShowNotices(@PathVariable String storeUrl, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		return "main/mainNotice";
	}
	
	// 공지사항 상세
	@GetMapping("/noticedetail")
	public String ShowNoticedetail(@PathVariable String storeUrl, @RequestParam int noticeId, Model model) {
		model.addAttribute("storeUrl",storeUrl);
		model.addAttribute("noticeId",noticeId);
		return "main/mainNotice";
	}
	
	

}
