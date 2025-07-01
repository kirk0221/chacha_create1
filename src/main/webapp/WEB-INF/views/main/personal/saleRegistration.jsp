<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>개인 판매 물품 등록</title>
  <link rel="stylesheet" href="${cpath}/resources/css/main/personal/saleRegistration.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <!-- ✅ Include Header & Nav -->
<jsp:include page="/common/header.jsp" />
<jsp:include page="/common/main_nav.jsp" />

<main class="register-container">
<jsp:include page="/common/main_personal_subnav.jsp" />

  <div class="explanation-box">
    <p>여기에는 개인판매 물품 등록하고 어쩌고 저쩌고 하는 방법들을 설명해놓는 칸입니다.<br>아래에는 접거나 사진을 넣고 만들 예정입니다.</p>
    <button class="open-store-btn">스토어 개설 신청</button>
  </div>

  <!-- 슬라이드 버튼 -->
  <button class="slide-arrow left">&lt;</button>

  <!-- 슬라이드 전체 -->
  <div class="slider-wrapper">
    <div class="slide-container">

      <!-- 한 세트 -->
      <div class="slide-full">
        <div class="slide-card">
          <div class="img-placeholder"></div>
          <div class="product-info">
            <h3>이곳에 상품명을 입력하세요</h3>
            <p><strong>10,000</strong> 원</p>
            <p>재고 <strong>NNN</strong> 개</p>
            <div class="category">
              카테고리
              <div class="category-box" id="category-box"></div>
              <button id="add-category">추가</button>
            </div>
          </div>
        </div>
        <button class="detail-toggle">상세페이지 만들기</button>
        <div class="detail-form" style="display:none;">
          <textarea placeholder="판매 물품에 대한 상세 설명을 입력하세요."></textarea>
        </div>
        <div class="submit-section">
          <button class="submit-btn">판매 페이지에 상품 등록</button>
        </div>
      </div>

      <!-- 두 번째 세트 -->
      <div class="slide-full">
        <div class="slide-card">
          <div class="img-placeholder"></div>
          <div class="product-info">
            <h3>다른 등록 예시</h3>
            <p><strong>20,000</strong> 원</p>
            <p>재고 <strong>NN</strong> 개</p>
            <div class="category">
              카테고리
              <div class="category-box" id="category-box2"></div>
              <button id="add-category2">추가</button>
            </div>
          </div>
        </div>
        <button class="detail-toggle">상세페이지 만들기</button>
        <div class="detail-form" style="display:none;">
          <textarea placeholder="판매 물품에 대한 상세 설명을 입력하세요."></textarea>
        </div>
        <div class="submit-section">
          <button class="submit-btn">판매 페이지에 상품 등록</button>
        </div>
      </div>

    </div>
  </div>

  <!-- 슬라이드 버튼 -->
  <button class="slide-arrow right">&gt;</button>
</main>

<footer>
  <div class="footer-inner">
    <div class="footer-logo">뜨락상회</div>
    <p>마음을 모은 생활 복지 플랫폼</p>
    <div class="footer-inputs">
      <input type="text" placeholder="연락처">
      <input type="text" placeholder="연락처2">
    </div>
  </div>
</footer>

<script>
  $(function() {
    let currentSlide = 0;
    const slides = $('.slide-container .slide-full');
    const container = $('.slide-container');

    function updateSlide() {
      const offset = -currentSlide * 100;
      container.css('transform', `translateX(${offset}%)`);
    }

    $('.slide-arrow.left').click(function () {
      if (currentSlide > 0) {
        currentSlide--;
        updateSlide();
      }
    });

    $('.slide-arrow.right').click(function () {
      if (currentSlide < slides.length - 1) {
        currentSlide++;
        updateSlide();
      }
    });

    $('.detail-toggle').click(function () {
      $(this).next('.detail-form').slideToggle();
    });

    $('#add-category').click(function () {
      $('#category-box').append(`<span class="category-item">카테고리1</span>`);
    });
    $('#add-category2').click(function () {
      $('#category-box2').append(`<span class="category-item">카테고리2</span>`);
    });
  });
</script>

</body>
</html>
