package com.chacha.create.service.store_common.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.dto.member.CartViewDTO;
import com.chacha.create.common.entity.member.CartEntity;
import com.chacha.create.common.mapper.member.CartMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyCartService {

    @Autowired
    private CartMapper cartMapper;

    // 장바구니 View 목록 조회
    @Transactional
    public List<CartViewDTO> selectForCartViewList(int memberId) {
        return cartMapper.selectForCartViewList(memberId);
    }

    // 장바구니 상품 추가 후 View 반환 (담겨 있는 상품일 시 개수 누적)
    @Transactional
    public CartViewDTO saveCartItemAndGetView(CartEntity cart) {
        CartEntity existingItem = cartMapper.selectForCartItem(cart.getMemberId(), cart.getProductId());
        if (existingItem != null) {
        	existingItem.setProductCnt(existingItem.getProductCnt() + cart.getProductCnt());
            cartMapper.updateForProductCnt(existingItem);
        } else {
            cartMapper.insert(cart);
        }
        return cartMapper.selectForCartViewItem(cart.getMemberId(), cart.getProductId());
    }

    // 장바구니 항목 수량 수정
    @Transactional
    public void updateForProductCnt(CartEntity cart) {
        cartMapper.updateForProductCnt(cart);
    }

    // 장바구니 단건 삭제
    @Transactional
    public void deleteByCartId(int cartId) {
        cartMapper.deleteByCartId(cartId);
    }

    // 장바구니 전체 삭제
    @Transactional
    public void deleteByMemberId(int memberId) {
        cartMapper.deleteByMemberId(memberId);
    }
}
