<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/orderlist.css" />
</head>
<body>
<div class="order-history-page">
  <div class="order-history-layout">

        <!-- 사이드 메뉴 -->
    <aside class="sidebar-menu">
      <div class="menu-item">
        <span>마이정보수정</span>
        <span class="arrow">&gt;</span>
      </div>
      <div class="menu-item ">
        <span>장바구니</span>
        <span class="arrow">&gt;</span>
      </div>
      <div class="menu-item selected">
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

    <!-- 주문 내역 컨텐츠 -->
    <section class="order-list-section">

	<!-- 배송중인 주문내역 -->
	<div class="block-header">
	    <h2 class="block-title">배송중인 주문내역</h2>
	    <div class="block-divider"></div>
	  </div>
	<div class="order-block">
	
	  <!-- 컬럼 제목 행 -->
	  <div class="order-item order-item-header">
	    <div class="order-date">주문일</div>
	    <div class="order-item-image">상품사진</div>
	    <div class="order-item-details">
	      <div class="order-product-info-header">상품정보</div>
	      <div class="order-qty-header">수량</div>
	      <div class="order-price-header">가격</div>
	      <div class="order-footer-header">배송 상태</div>
	    </div>
	  </div>
	
	  <!-- 실제 주문 아이템 -->
	  <div class="order-item">
	    <div class="order-date">2025-06-12</div>
	    <img class="order-item-image" src="${pageContext.request.contextPath}/resources/img/home.jpg" alt="상품 이미지" />
	    <div class="order-item-details">
	      <div class="order-product-info">
	        <div class="order-store-name">000 스토어</div>
	        <div class="order-product-name">호박 수세미</div>
	        <div class="order-product-desc">설명 생략...</div>
	      </div>
	      <div class="order-qty">
	        <span class="order-qty">2</span>
	      </div>
	      <div class="order-price">
	        <span class="order-price">4,000원</span>
	      </div>
	      <div class="order-footer">
	        <div class="order-status">배송중</div>
	        <button class="btn-detail">주문상세</button>
	      </div>
	    </div>
	  </div>
	  <!-- 복제용 주문 아이템들 ... -->
	</div>
	
	<!-- 완료된 주문내역 -->
	<div class="block-header">
	    <h2 class="block-title">마이 주문 내역</h2>
	    <div class="block-divider"></div>
	  </div>
	<div class="order-block">
	
	  <!-- 컬럼 제목 행 -->
	  <div class="order-item order-item-header">
	    <div class="order-date">주문일</div>
	    <div class="order-item-image">상품사진</div>
	    <div class="order-item-details">
	      <div class="order-product-info-header">상품정보</div>
	      <div class="order-qty-header">수량</div>
	      <div class="order-price-header">가격</div>
	      <div class="order-footer-header">배송 상태</div>
	    </div>
	  </div>
	
	  <!-- 실제 주문 아이템 -->
	  <div class="order-item">
	    <div class="order-date">2025-06-12</div>
	    <img class="order-item-image" src="${pageContext.request.contextPath}/resources/img/home.jpg" alt="상품 이미지" />
	    <div class="order-item-details">
	      <div class="order-product-info">
	        <div class="order-store-name">000 스토어</div>
	        <div class="order-product-name">호박 수세미</div>
	        <div class="order-product-desc">설명 생략...아니고 길게길게야호</div>
	      </div>
	      <div class="order-qty">
	        <span class="order-qty">3</span>
	      </div>
	      <div class="order-price">
	        <span class="order-price">4,000원</span>
	      </div>
	      <div class="order-footer">
	        <div class="order-status">배송 완료</div>
	        <button class="btn-detail">주문상세</button>
	      </div>
	    </div>
	  </div>
	  <!-- 복제용 주문 아이템들 ... -->
	</div>


    </section>
  </div>
</div>
</body>
</html>