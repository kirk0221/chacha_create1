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
        <div class="logo">
        	<img src = "resources/images/logo/logohorizon_green.png" alt="뜨락상회 로고 " style="height: 80px;" ></div>
        <div class="menu">
            <a href="#">전체상품</a>
            <a href="#">스토어</a>
            <a href="#">공지/소식</a>
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
        <div class="swiper-wrapper" id="store-swiper-wrapper">
            <!-- ✅ Ajax로 인기 스토어 카드가 여기에 동적으로 추가됨 -->
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
function renderStoreSwiper(data) {
    const wrapper = document.getElementById("store-swiper-wrapper");
    wrapper.innerHTML = ""; // 기존 비우기

    data.forEach((store, i) => {
        const slide = document.createElement("div");
        slide.classList.add("swiper-slide");

        slide.innerHTML = `
            <div class="card">
                <img src="${store.imageUrl}" alt="스토어${i + 1}">
                <p>${store.name}</p>
            </div>
        `;

        wrapper.appendChild(slide);
    });

    // 기존 swiper 제거 후 다시 초기화 (중복 방지)
    if (window.storeSwiper) window.storeSwiper.destroy(true, true);
    window.storeSwiper = new Swiper('.store-swiper', {
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
}

document.addEventListener("DOMContentLoaded", function () {
    // ✅ 예시용 더미 데이터로 swiper 작동 확인
    const dummyStores = [
        { name: "뜨락공방1", imageUrl: "resources/images/logo/stores1.jpg" },
        { name: "뜨락공방2", imageUrl: "resources/images/logo/stores2.jpg" },
        { name: "뜨락공방3", imageUrl: "resources/images/logo/stores3.jpg" },
        { name: "뜨락공방4", imageUrl: "resources/images/logo/stores4.jpg" },
        { name: "뜨락공방5", imageUrl: "resources/images/logo/stores5.jpg" },
        { name: "뜨락공방6", imageUrl: "resources/images/logo/stores5.jpg" },
        { name: "뜨락공방7", imageUrl: "resources/images/logo/stores5.jpg" },
        { name: "뜨락공방8", imageUrl: "resources/images/logo/stores5.jpg" },
        { name: "뜨락공방9", imageUrl: "resources/images/logo/stores5.jpg" },
        { name: "뜨락공방10", imageUrl: "resources/images/logo/stores5.jpg" }
    ];

    renderStoreSwiper(dummyStores); // ✅ 예시 데이터 삽입

    // 실제 Ajax 연동시 아래 fetch 주석 해제
    /*
    fetch("/api/stores/top10")
        .then(res => res.json())
        .then(data => renderStoreSwiper(data))
        .catch(err => console.error("스토어 불러오기 실패:", err));
    */

    // 인기 상품 swiper 초기화
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
