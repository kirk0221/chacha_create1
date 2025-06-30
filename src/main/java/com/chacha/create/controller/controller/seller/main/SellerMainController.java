package com.chacha.create.controller.controller.seller.main;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chacha.create.service.seller.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/{storeUrl}/seller")
@RequiredArgsConstructor
public class SellerMainController {
	
	final ProductService productService;
	// 판매자 메인페이지
	@GetMapping("/main")
	public String showMainPage(@PathVariable String storeUrl, Model model) {
		return "seller/mypage_seller";
	 }
	
	// 판매자 상품 목록
	@GetMapping("/productinsert")
    public String showProductInsertPage(@PathVariable String storeUrl, Model model) {
		return "seller/product_insert";
    }
	
	// 판매자 상품 조회
	@GetMapping("/products")
    public String showProductListPage(@PathVariable String storeUrl, Model model) {
        return "seller/product_select";
    }
	
	// 판매 상품 상세 보기
	@GetMapping("/productdetail/{productId}")
    public String showProductDetailPage(@PathVariable String storeUrl,
                                        @PathVariable int productId,
                                        Model model) {
        return "buyer/productdetail";
	}
	
	// 판매 상품 수정
	@GetMapping("/productupdate/{productId}")
    public String showProductUpdatePage(@PathVariable String storeUrl,
                                        @PathVariable int productId,
                                        Model model) {
        return "seller/product_update";
	}
	
	// 판매 정산 관리
		@GetMapping("/management/settlement")
	    public String showSellrSettlementPage(@PathVariable String storeUrl,
	                                        Model model) {
	        return "mainauth/pages/storeSettlementContent";
		}
	
	// 판매 주문 목록
	// 나중에 추가 예정
	
	// 판매 리뷰 관리
	@GetMapping("/reviews")
	public String showReviewPage() {
		return "seller/seller_review";
	}
	
	// 문의 메시지
	@GetMapping("/chat")
	public String showChatPage() {
		return "seller/chat";
	}
	
	// 폐업
	@GetMapping("/close")
	public String showDonePage() {
		return "seller/closure";
	}
	
}