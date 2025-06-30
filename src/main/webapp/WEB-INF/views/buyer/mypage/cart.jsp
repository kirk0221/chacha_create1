<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cart.css" />
</head>
<body>
<div class="cart-page">

  <!-- 메인 레이아웃 -->
  <div class="cart-layout">

    <!-- 사이드 메뉴 -->
    <aside class="sidebar-menu">
      <div class="menu-item">
        <span>마이정보수정</span>
        <span class="arrow">&gt;</span>
      </div>
      <div class="menu-item selected">
        <span>장바구니</span>
        <span class="arrow">&gt;</span>
      </div>
      <div class="menu-item">
        <span>주문내역</span>
        <span class="arrow">&gt;</span>
      </div>
      <div class="menu-item">
        <span>관심사 선택</span>
        <span class="arrow">&gt;</span>
      </div>
      <div class="menu-item">
        <span>작성 리뷰 확인</span>
        <span class="arrow">&gt;</span>
      </div>
    </aside>

    <!-- 장바구니 목록 영역 -->
    <section class="cart-section">

      <!-- 현재 스토어 -->
      <div class="cart-block">
        <div class="block-header">
          <h2 class="block-title">현재 스토어 장바구니</h2>
          <div class="block-divider"></div>
        </div>

        <div class="cart-item">
          <input type="checkbox" class="item-checkbox" />
          <img class="item-image" src="${pageContext.request.contextPath}/resources/img/home.jpg" alt="상품 이미지" />
          <div class="item-details">
            <div class="store-name">000 스토어</div>
            <div class="product-name">상품명 1</div>
            <div class="product-description">상품설명 블라블라 예시어쩌구...</div>
            <div class="product-price">10,000원</div>
            <div class="quantity-controls">
              <button class="btn-decrease">-</button>
              <span class="quantity">1</span>
              <button class="btn-increase">+</button>
            </div>
          </div>
        </div>
      </div>

      <!-- 전체 스토어 -->
      <div class="cart-block">
        <div class="block-header">
          <h2 class="block-title">전체 스토어 장바구니</h2>
          <div class="block-divider"></div>
        </div>

        <!-- 반복 상품 -->
        <div class="cart-item">
          <input type="checkbox" class="item-checkbox" />
          <img class="item-image" src="${pageContext.request.contextPath}/resources/img/home.jpg" alt="상품 이미지" />
          <div class="item-details">
            <div class="store-name">000 스토어</div>
            <div class="product-name">상품명 2</div>
            <div class="product-description">상품설명 블라블라 예시어쩌구...</div>
            <div class="product-price">20,000원</div>
            <div class="quantity-controls">
              <button class="btn-decrease">-</button>
              <span class="quantity">2</span>
              <button class="btn-increase">+</button>
            </div>
          </div>
        </div>

        <div class="cart-item">
          <input type="checkbox" class="item-checkbox" />
          <img class="item-image" src="${pageContext.request.contextPath}/resources/img/home.jpg" alt="상품 이미지" />
          <div class="item-details">
            <div class="store-name">000 스토어</div>
            <div class="product-name">상품명 3</div>
            <div class="product-description">상품설명 블라블라 예시어쩌구...</div>
            <div class="product-price">9,000원</div>
            <div class="quantity-controls">
              <button class="btn-decrease">-</button>
              <span class="quantity">2</span>
              <button class="btn-increase">+</button>
            </div>
          </div>
        </div>
      </div>

    </section>

    <!-- 주문 요약 -->
    <aside class="order-summary">
      <h3>주문 예상 금액</h3>
      <div class="summary-count">선택 상품 (2)</div>

      <div class="summary-item">
        <span>상품 1</span>
        <span>10,000원</span>
      </div>
      <div class="summary-item">
        <span>상품 2</span>
        <span>20,000원</span>
      </div>
      <div class="summary-item">
        <span>상품 3</span>
        <span>9,000원</span>
      </div>
      <div class="summary-item">
        <span>배송비</span>
        <span>2,500원</span>
      </div>

      <hr/>
      <div class="summary-total">
        <span>총 금액</span>
        <span>41,500원</span>
      </div>

      <div class="checkout-wrapper">
        <button class="checkout-btn">결제하기</button>
      </div>
    </aside>

  </div>
</div>
</body>

</html>