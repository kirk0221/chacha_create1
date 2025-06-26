<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>HandCraft Mall</title>

    <!-- Swiper CSS -->
    <link rel="stylesheet" href="https://unpkg.com/swiper@9/swiper-bundle.min.css" />

    <!-- 분리한 CSS -->
    <link rel="stylesheet" type="text/css" href="resources/css/main.css">

    <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper@9/swiper-bundle.min.js"></script>
</head>

<body>

<header>
    <div class="header-inner">
        <div class="login-area">
            <button>로그인</button>
            <button>로그아웃</button>
        </div>
    </div>
</header>

<nav>
    <div class="nav-inner">
        <div class="logo">HandCraft Mall</div>
        <div class="menu">
            <a href="#">전체상품</a>
            <a href="#">스토어 공지/소식</a>
            <a href="#">개인판매</a>
            <a href="#">클래스</a>
            <a href="#">마이페이지</a>
            <a href="#">장바구니</a>
        </div>
    </div>
</nav>

<main>

    <div class="banner">
        <img src="resources/images/banner1.jpg" alt="배너1">
    </div>

    <!-- 인기 스토어 -->
    <section>
        <h2>인기 스토어</h2>
        <div class="swiper store-swiper">
            <div class="swiper-wrapper">
                <% for(int i=1; i<=10; i++) { %>
                <div class="swiper-slide">
                    <div class="card">
                        <img src="resources/images/store<%=i%>.jpg" alt="스토어<%=i%>">
                        <p>스토어 이름 <%=i%></p>
                    </div>
                </div>
                <% } %>
            </div>
            <div class="swiper-pagination"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-button-next"></div>
        </div>
    </section>

    <!-- 인기 상품 -->
    <section>
        <h2>인기 상품</h2>
        <div class="swiper product-swiper">
            <div class="swiper-wrapper">
                <% for(int i=1; i<=10; i++) { %>
                <div class="swiper-slide">
                    <div class="card">
                        <img src="resources/images/product<%=i%>.jpg" alt="상품<%=i%>">
                        <p>상품명 <%=i%></p>
                        <span>가격: 10,000원</span>
                    </div>
                </div>
                <% } %>
            </div>
            <div class="swiper-pagination"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-button-next"></div>
        </div>
    </section>

    <!-- 신상품 -->
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

<footer>
    &copy; 2025 HandCraft Mall. All Rights Reserved.
</footer>

<script>
document.addEventListener("DOMContentLoaded", function () {
    new Swiper('.store-swiper', {
        slidesPerView: 3,
        spaceBetween: 30,
        loop: true,
        autoplay: { delay: 3000 },
        navigation: {
            nextEl: '.store-swiper .swiper-button-next',
            prevEl: '.store-swiper .swiper-button-prev',
        },
        pagination: {
            el: '.store-swiper .swiper-pagination',
            clickable: true,
        },
        breakpoints: {
            1024: { slidesPerView: 3 },
            768: { slidesPerView: 2 },
            480: { slidesPerView: 1 }
        }
    });

    new Swiper('.product-swiper', {
        slidesPerView: 3,
        spaceBetween: 30,
        loop: true,
        autoplay: { delay: 3000 },
        navigation: {
            nextEl: '.product-swiper .swiper-button-next',
            prevEl: '.product-swiper .swiper-button-prev',
        },
        pagination: {
            el: '.product-swiper .swiper-pagination',
            clickable: true,
        },
        breakpoints: {
            1024: { slidesPerView: 3 },
            768: { slidesPerView: 2 },
            480: { slidesPerView: 1 }
        }
    });
});
</script>

</body>
</html>
