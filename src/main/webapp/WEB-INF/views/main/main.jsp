<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>HandCraft Mall</title>

  <!-- Swiper CSS -->
  <link rel="stylesheet" href="https://unpkg.com/swiper@9/swiper-bundle.min.css" />

  <!-- Custom CSS -->
  <link rel="stylesheet" type="text/css" href="${cpath}/resources/css/main/main.css">
  

</head>
<body>
  
  <!-- ✅ Include Header & Nav -->
<jsp:include page="/common/header.jsp" />
<jsp:include page="/common/main_nav.jsp" />

  <!-- MAIN CONTENT -->
  <main class="container-1440">

    <!-- 1. 광고 배너 -->
    <!-- 광고 배너 섹션 -->
<section class="banner-section">
  <!-- 왼쪽: 큰 광고 슬라이드 -->
  <div class="banner-left swiper banner-swiper">
    <div class="swiper-wrapper">
      <div class="swiper-slide banner-card">
        <div class="banner-info">
          <p class="banner-tag">지금이 기회!</p>
          <h2 class="banner-title">뜨락콘솔 한정판</h2>
          <p class="banner-desc">최대 50% 할인, 무료 체험권 제공!</p>
          <a href="#" class="banner-btn">바로 구매</a>
        </div>
        <img src="resources/images/banner1.jpg" alt="광고1">
        
      </div>
      <div class="swiper-slide banner-card">
        <div class="banner-info">
          <p class="banner-tag">놓치지 마세요</p>
          <h2 class="banner-title">수제 클래스 오픈</h2>
          <p class="banner-desc">온라인 클래스 신청 시 20% 할인</p>
          <a href="#" class="banner-btn">바로 보기</a>
        </div>
        <img src="resources/images/banner2.jpg" alt="광고2">
        
      </div>
    </div>
    <div class="swiper-pagination banner-pagination"></div>
  </div>

  <!-- 오른쪽: 작은 고정 광고 2개 -->
  <div class="banner-right">
    <a href="#" class="small-banner orange">
      <div class="text">
        <p class="label">SUMMER SALE</p>
        <h4>픽셀폰 6 프로</h4>
        <p class="discount">29% 할인</p>
        <button class="banner-btn small">SHOP NOW</button>
      </div>
      <img src="resources/images/small1.jpg" alt="소광고1">
    </a>

    <a href="#" class="small-banner white">
      <div class="text">
        <h4>뜨락 이어폰 Pro</h4>
        <p class="price">₩99,000</p>
        <button class="banner-btn small">SHOP NOW</button>
      </div>
      <img src="resources/images/small2.jpg" alt="소광고2">
    </a>
  </div>
</section>



    <!-- 2. 인기 스토어 -->
    <section>
      <h2>인기 스토어</h2>
      <div class="swiper store-swiper">
        <div class="swiper-wrapper" id="store-swiper-wrapper">
          <% for(int i = 1; i <= 10; i++) { %>
          <div class="swiper-slide">
            <div class="card">
              <img src="resources/images/logo/stores<%= (i % 5 == 0 ? 5 : i % 5) %>.jpg" alt="스토어<%=i%>">
              <p>스토어명 <%=i%></p>
            </div>
          </div>
          <% } %>
        </div>
        <div class="swiper-pagination store-pagination"></div>
        <div class="swiper-button-prev store-prev"></div>
        <div class="swiper-button-next store-next"></div>
      </div>
    </section>

<!-- 인기 상품 영역 디벨롭: JSP 포함 버전 -->
<section class="product-section">
  <h2>인기 상품</h2>
  <div class="swiper product-swiper">
    <div class="swiper-wrapper">
      <% for (int i = 1; i <= 10; i++) { %>
        <div class="swiper-slide">
          <div class="product-card">	
            <div class="product-image-box">
              <img src="resources/images/product<%=i%>.jpg" alt="인기상품<%=i%>">
              <div class="product-icon">
                <a href="#"><span class="material-symbols-outlined">arrow_outward</span></a>
              	<div class="curve-shadow"></div>
              </div>
            </div>
            <div class="product-content">
              <h3>상품명 <%=i%></h3>
              <p>10,000원</p>
              <div class="category-badges">
              <span class="badge">천연</span>
              <span class="badge">핸드메이드</span>
              </div>
            </div>
          </div>
        </div>
      <% } %>
    </div>

    <div class="swiper-pagination product-pagination"></div>
    <div class="swiper-button-prev product-prev"></div>
    <div class="swiper-button-next product-next"></div>
  </div>
</section>

    <!-- 4. 금주 신상품 -->
    <section>
      <div class="title-bar">
        <h2>금주 신상품</h2>
        <a href="#" class="view-all">전체보기</a>
      </div>
      <div class="preview-grid">
        <% for(int i=1; i<=8; i++) { %>
        <div class="preview-card">
          <img src="resources/images/new<%=i%>.jpg" alt="신상품<%=i%>">
          <p>신상품 <%=i%></p>
        </div>
        <% } %>
      </div>
    </section>
  </main>

  <!-- FOOTER -->
  <footer>
    &copy; 2025 HandCraft Mall. All Rights Reserved.
  </footer>

  <!-- JS -->
  <script src="https://unpkg.com/swiper@9/swiper-bundle.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/main_store.js"></script>
</body>
</html>
