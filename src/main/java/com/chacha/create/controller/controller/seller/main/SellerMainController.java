package com.chacha.create.controller.controller.seller.main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chacha.create.common.dto.order.OrderSumDTO;
import com.chacha.create.service.seller.main.SellerMainService;
import com.chacha.create.service.seller.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// productDetail 오류

@Slf4j
@Controller
@RequestMapping("/{storeUrl}/seller")
@RequiredArgsConstructor
public class SellerMainController {
	
	
	final ProductService productService;
	 
	final SellerMainService sell;
	
	
	// 판매자 메인페이지
	@GetMapping("/main")
	public String showMainPage(@PathVariable String storeUrl, Model model) {
		 

		List<Map<String, Object>> statusList = sell.selectByStatus(storeUrl);
		List<Map<String, Object>> reviewList = sell.selectByStoreUrl(storeUrl);
		List<OrderSumDTO> orderSumList = sell.selectByDayOrderSum(storeUrl);
		
		int reviewCount = reviewList.size();
		
		
		model.addAttribute("reviewCount", reviewCount);
		model.addAttribute("storeUrl", storeUrl);
		model.addAttribute("statusList", statusList);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("orderSumList", orderSumList);
		
		 
		return "store/seller/sellerMyPage";
	 }
	
	// 판매자 상품 목록
	@GetMapping("/productinsert")
    public String showProductInsertPage(@PathVariable String storeUrl, Model model) {
		return "store/seller/productInsert";
    }
	
	// 판매자 상품 조회
	@GetMapping("/products")
    public String showProductListPage(@PathVariable String storeUrl, Model model) {
        return "store/seller/productSelect";
    }
	
	// 판매 상품 상세 보기
	@GetMapping("/productdetail/{productId}")
    public String showProductDetailPage(@PathVariable String storeUrl,
                                        @PathVariable int productId,
                                        Model model) {
        return "store/productDetail";
	}
	
	// 판매 상품 수정
	@GetMapping("/productupdate/{productId}")
    public String showProductUpdatePage(@PathVariable String storeUrl,
                                        @PathVariable int productId,
                                        Model model) {
        return "store/seller/productUpdate";
	}
	
	// 판매 정산 관리
		@GetMapping("/management/settlement")
	    public String showSellrSettlementPage(@PathVariable String storeUrl,
	                                        Model model) {
	        return "store/seller/sellerSettlement";
		}
	
	// 판매 주문 목록 --- 추가 필요
//	@GetMapping("/management/order")
//	public String showOrderPage() {
//		return "";
//	}
	
	// 판매 리뷰 관리
	@GetMapping("/reviews")
	public String showReviewPage() {
		return "store/seller/sellerReview";
	}
	
	// 문의 메시지
	@GetMapping("/chat")
	public String showChatPage() {
		return "store/chat";
	}
	
	// 스토어 관리 --- 추가 필요
//	@GetMapping("/management/seller")
//	public String storeManagement() {
//		return "";
//	}
	
	// 공지사항목록
	@GetMapping("/management/notices")
	public String showNoticePage() {
		return "store/seller/sellerNotice";
	}
	
	// 폐업
	@GetMapping("/close")
	public String showDonePage() {
		return "store/seller/storeClose";
	}
	
}
