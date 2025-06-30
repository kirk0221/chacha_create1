package com.chacha.create.controller.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.member.CartViewDTO;
import com.chacha.create.common.entity.member.CartEntity;
import com.chacha.create.service.store_common.mypage.CartService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/main/mypage/cart")
public class MyCartRestController {

    @Autowired
    private CartService cartService;

    // 장바구니 상세 정보 조회
    @GetMapping
    public List<CartViewDTO> getCartViewList(@RequestParam int memberId) {
        return cartService.selectForCartViewList(memberId);
    }

    // 장바구니 상품 정보 추가
    @PostMapping
    public CartViewDTO addCartItem(@RequestBody CartEntity cart) {
        CartViewDTO cartViewDTO = cartService.saveCartItemAndGetView(cart);
        return cartViewDTO;
    }

    @PutMapping
    public ResponseEntity<String> updateCartItem(@RequestBody CartEntity cart) {
        cartService.updateForProductCnt(cart);
        return ResponseEntity.ok("수량 수정 완료");
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<String> deleteCartItem(@PathVariable int cartId) {
        cartService.deleteByCartId(cartId);
        return ResponseEntity.ok("장바구니 항목(1) 삭제 완료");
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll(@RequestParam int memberId) {
        cartService.deleteByMemberId(memberId);
        return ResponseEntity.ok("장바구니 전체 삭제 완료");
    }
}