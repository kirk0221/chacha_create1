<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/store/buyer/mypage/orderDetail.css" />
</head>
<body>
<div class="order-detail-page">
  <div class="order-detail-layout">

    <!-- 사이드 메뉴 -->
    <aside class="sidebar-menu">
      <div class="menu-item"><span>마이정보수정</span><span class="arrow">&gt;</span></div>
      <div class="menu-item"><span>장바구니</span><span class="arrow">&gt;</span></div>
      <div class="menu-item selected"><span>주문내역</span><span class="arrow">&gt;</span></div>
      <div class="menu-item"><span>관심사 선택</span><span class="arrow">&gt;</span></div>
      <div class="menu-item"><span>작성 리뷰 확인</span><span class="arrow">&gt;</span></div>
    </aside>

    <!-- 주문 상세 내용 -->
    <section class="order-detail-content">

      <!-- 주문 정보 -->
      <div class="block-header">
          <h2 class="block-title">주문 정보</h2>
          <div class="block-divider"></div>
      </div>
      <div class="section-block">
        <div class="product-desc">2025-06-27</div>
        <p>주문번호 <strong>12345678</strong></p>
      </div>

      <!-- 주문 상품 리스트 -->
      <div class="block-header">
          <h2 class="block-title">주문 상품</h2>
          <div class="block-divider"></div>
        </div>
      <div class="section-block">

        <!-- 상품 1 -->
        <div class="product-item">
          <div class="product-box">
            <img src="${pageContext.request.contextPath}/resources/img/home.jpg" class="product-image" />
            <div class="product-info">
              <div class="store-name">ABC 상점</div>
              <div class="product-name">고급 원두 커피</div>
              <div class="product-desc">부드럽고 진한 맛의 프리미엄 원두입니다.</div>
              <div class="product-price">₩ 29,000</div>
            </div>
            <div class="review-wrapper">
              <button class="review-button">리뷰 쓰기</button>
            </div>
          </div>
        </div>

        <!-- 상품 2 -->
        <div class="product-item">
          <div class="product-box">
            <img src="${pageContext.request.contextPath}/resources/img/home.jpg" class="product-image" />
            <div class="product-info">
              <div class="store-name">DEF 마켓</div>
              <div class="product-name">핸드드립 커피 필터</div>
              <div class="product-desc">깔끔한 맛을 위한 고급 종이 필터입니다.</div>
              <div class="product-price">₩ 19,000</div>
            </div>
            <div class="review-wrapper">
              <button class="review-button">리뷰 쓰기</button>
            </div>
          </div>
        </div>
      </div>

      <!-- 배송지 정보 -->
      <div class="block-header">
          <h2 class="block-title">배송지 정보</h2>
          <div class="block-divider"></div>
        </div>
      <div class="section-block">
        <p><strong>홍길동</strong></p>
        <div class="product-desc">010-1234-5678</div>
        <p>서울특별시 강남구 테헤란로 123</p>
      </div>

      <!-- 결제 정보 -->
      <div class="block-header">
          <h2 class="block-title">결제 정보</h2>
          <div class="block-divider"></div>
        </div>
      <div class="section-block payment-summary">

		  <!-- 강조된 총 결제 금액 -->
		  <div class="payment-total">
		    <span>총 결제 금액</span>
		    <span>48,000 원</span>
		  </div>
		
		  <!-- 세부 항목: 상품금액, 배송비 -->
		  <div class="payment-detail">
		    <span class="label">상품 금액</span>
		    <span class="value">45,500 원</span>
		  </div>
		  <div class="payment-detail">
		    <span class="label">배송비</span>
		    <span class="value">2,500 원</span>
		  </div>
		
		  <hr class="payment-divider"/>
		
		  <!-- 결제 수단 -->
		  <div class="payment-detail">
		    <span class="label">카드 결제</span>
		    <span class="value">48,000 원</span>
		  </div>
		  <div class="payment-note">신한카드 (****-****-****-1234)</div>
		</div>


    </section>

  </div>
</div>
</body>
</html>
