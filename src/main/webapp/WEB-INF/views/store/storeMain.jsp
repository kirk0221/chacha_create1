<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>스토어메인페이지</title>
  
    <!-- ✅ Include Header & Nav -->
<%@ include file="/common/header.jsp"%>
<jsp:include page="/common/header.jsp" />
<jsp:include page="/common/storeMain_nav.jsp" />

<script src="${cpath}/resources/js/store/storeMain.js"></script>
  
  <!-- Swiper CSS -->
  <link rel="stylesheet" href="https://unpkg.com/swiper@9/swiper-bundle.min.css" />
  <!-- Custom CSS -->
  <link rel="stylesheet" type="text/css" href="${cpath}/resources/css/store/seller/storeMain.css">
</head>
<body>
<input type="hidden" id="cpath" value="${cpath}">
<input type="hidden" id="storeUrl" value="${storeUrl}">
  
  
  <!-- MAIN CONTENT -->
  <main class="container-1440">

<!-- 인기 상품 영역 -->
<section class="product-section" >
  <h2>인기 상품</h2>
  
  	<div class="swiper product-swiper">
    		<div class="swiper-wrapper" id="best-product-wrapper" >
			<!-- 동적으로 추가 -->
		</div>
    <div class="swiper-pagination product-pagination"></div>
  </div>
</section>

<!-- 대표 상품 영역 -->
<section class="product-section" >
  <h2>대표 상품</h2>
  
  	<div class="swiper product-swiper">
    		<div class="swiper-wrapper" id="main-product-wrapper" >
			<!-- 동적으로 추가 -->
		</div>
    <div class="swiper-pagination product-pagination"></div>
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
