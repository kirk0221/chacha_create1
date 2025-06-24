<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>뜨락상회 메인</title>
    <link rel="stylesheet" href="resources/css/main_styletest.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<!-- 상단 로그인 영역 -->
<div class="top-header">
  <div class="top-header-inner">
    <div class="login-buttons">
      <a href="${pageContext.request.contextPath}/views/member/login.jsp" class="login-btn">로그인</a>
      <span class="divider">|</span>
      <a href="${pageContext.request.contextPath}/views/member/signup.jsp" class="login-btn">회원가입</a>
    </div>
  </div>
</div>

<!-- 네비게이션 영역 -->
<div class="nav-wrapper">
  <div class="nav-inner">
    <div class="logo">뜨락상회</div>
    <nav class="main-nav">
        <a href="#">전체 상품</a>
        <a href="#">스토어</a>
        <a href="#">전입상품</a>
        <a href="#">개인 판매</a>
        <a href="#">클래스</a>
        <a href="#">마이페이지</a>
        <a href="#">장바구니</a>
    </nav>
  </div>
</div>

<!-- 메인 배너 -->
<section class="main-banner">
    <button class="slide-btn left" id="bannerSlideLeft">&lt;</button>
    <div class="banner-slider" id="banner-slider">
        <%@ include file="bannerSlides.jspf" %>
    </div>
    <button class="slide-btn right" id="bannerSlideRight">&gt;</button>
</section>

<!-- 인기 스토어 -->
<section class="section-wrapper">
  <h2>★ 인기 스토어</h2>
  <div class="slider-container">
      <button class="slide-btn left" id="storeSlideLeft">&lt;</button>
      <div class="store-slider" id="store-slider">
          <%@ include file="popularStores_test.jspf" %>
      </div>
      <button class="slide-btn right" id="storeSlideRight">&gt;</button>
  </div>
</section>

<!-- 인기 상품 -->
<section class="section-wrapper">
  <h2>★ 인기 상품</h2>
  <div class="slider-container">
      <button class="slide-btn left" id="productSlideLeft">&lt;</button>
      <div class="product-slider" id="product-slider">
          <%@ include file="popularProducts_test.jspf" %>
      </div>
      <button class="slide-btn right" id="productSlideRight">&gt;</button>
  </div>
</section>

<!-- 신규 상품 -->
<section class="section-wrapper">
  <h2>★ 신규 상품</h2>
  <div class="new-product-grid">
      <%@ include file="newProducts.jspf" %>
  </div>
</section>

<!-- 푸터 -->
<footer class="footer">
    <div class="footer-logo">뜨락상회</div>
    <div class="footer-text">
        입점문의 : 뜨락상회 운영팀 <br>
        123-45-67890 사업자등록번호 | 대표이사 김민건
    </div>
    <div class="footer-buttons">
        <button>문의하기</button>
        <button>입점신청</button>
    </div>
</footer>

<script src="resources/js/slider.js"></script>
</body>
</html>
