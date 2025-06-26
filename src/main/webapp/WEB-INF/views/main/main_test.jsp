<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>HandCraft Mall</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main_styletest.css">
</head>
<body>

    <!-- 상단 헤더 -->
    <header>
        <div class="top-header">
            <div class="logo">HandCraft Mall</div>
            <nav class="main-nav">
                <a href="#">전체 카테고리</a>
                <a href="#">선물추천</a>
                <a href="#">실시간구매</a>
                <a href="#">실시간후기</a>
                <a href="#">인기작품</a>
                <a href="#">소담상회</a>
            </nav>
            <div class="user-area">
                <span>김지민 님</span> | <a href="#">알림</a> | <a href="#">장바구니</a>
            </div>
        </div>
    </header>

    <!-- 메인 슬라이드 배너 -->
    <section class="main-banner">
        <div class="banner-container">
            <img src="${pageContext.request.contextPath}/resources/images/banner1.jpg" alt="이벤트 배너">
            <img src="${pageContext.request.contextPath}/resources/images/banner2.jpg" alt="이벤트 배너">
            <img src="${pageContext.request.contextPath}/resources/images/banner3.jpg" alt="이벤트 배너">
        </div>
    </section>

    <!-- 카테고리 아이콘 바로가기 -->
    <section class="category-shortcut">
        <div class="category-container">
            <div class="category-item">
                <img src="${pageContext.request.contextPath}/resources/images/icon_gift.png" alt="선물추천">
                <p>선물추천</p>
            </div>
            <div class="category-item">
                <img src="${pageContext.request.contextPath}/resources/images/icon_sale.png" alt="특가">
                <p>특가</p>
            </div>
            <div class="category-item">
                <img src="${pageContext.request.contextPath}/resources/images/icon_new.png" alt="신상">
                <p>신상</p>
            </div>
            <div class="category-item">
                <img src="${pageContext.request.contextPath}/resources/images/icon_best.png" alt="인기">
                <p>인기</p>
            </div>
            <div class="category-item">
                <img src="${pageContext.request.contextPath}/resources/images/icon_event.png" alt="이벤트">
                <p>이벤트</p>
            </div>
            <div class="category-item">
                <img src="${pageContext.request.contextPath}/resources/images/icon_coupon.png" alt="쿠폰">
                <p>쿠폰</p>
            </div>
        </div>
    </section>

    <!-- 메인 콘텐츠 -->
    <section class="main-content">
        <h2>오늘의 추천 작품</h2>
        <div class="product-list">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/sample1.jpg" alt="상품1">
                <div class="product-name">수제 원목 테이블</div>
                <div class="product-price">₩350,000</div>
            </div>
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/sample2.jpg" alt="상품2">
                <div class="product-name">핸드메이드 머그컵</div>
                <div class="product-price">₩45,000</div>
            </div>
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/sample3.jpg" alt="상품3">
                <div class="product-name">수제 비누 세트</div>
                <div class="product-price">₩15,000</div>
            </div>
        </div>
    </section>

    <!-- 푸터 -->
    <footer>
        <div class="footer-inner">
            <p>© 2025 HandCraft Mall. All rights reserved.</p>
        </div>
    </footer>

</body>
</html>
