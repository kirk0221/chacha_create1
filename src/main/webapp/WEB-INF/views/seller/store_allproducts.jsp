<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스토어 전체 상품 페이지</title>
<%@ include file="../common/header.jsp"%>
<link rel="stylesheet" href="${cpath}/resources/css/all_products.css">
</head>
<body>

<!-- 검색창 -->
<div id="product-search">
  <form id="search-form" action="/api/main/productlist" method="get">
    <input type="text" name="query" placeholder="상품명으로 검색하세요" id="search-input" />
    <button type="submit" id="search-button">🔍</button>
  </form>
</div>

<!-- 정렬 탭 -->

<!-- 상단 스토어명 -->
<div id="sort-group">
  <div id="sort-header">
    <h1 id="storename"><span id="store-name-dynamic"></span> 전체 상품</h1>
    <hr class="store-underline">
  </div>
</div>

<h3 class="category-title">상세카테고리</h3>

<div id="category-section">
  <!-- 이 안에 JS로 <div class="main-category-block"> 들이 들어갈 예정 -->
  
  <!-- 테스트용 -->
 <!-- <div class="main-category-block" data-category-id="furniture">
  <div class="main-category-header">
    <span class="category-name">가구</span>
    <span class="toggle-arrow">🔽</span>
    <label class="select-all"><input type="checkbox" class="check-all"> 전체 선택</label>
  </div>
  <div class="subcategory-container">
    <label><input type="checkbox" name="subcategory" value="101"> 의자</label>
    <label><input type="checkbox" name="subcategory" value="102"> 테이블</label>
    <label><input type="checkbox" name="subcategory" value="103"> 수납장</label>
  </div>
</div>

<div class="main-category-block" data-category-id="lighting">
  <div class="main-category-header">
    <span class="category-name">조명</span>
    <span class="toggle-arrow">🔽</span>
    <label class="select-all"><input type="checkbox" class="check-all"> 전체 선택</label>
  </div>
</div>-->
  
  

  <!-- 검색 버튼 -->
  <div class="category-search-btn-wrapper">
    <button type="button" class="category-search-btn">검색하기</button>
  </div>
</div>
  


<hr class="divider">

<div id="sort-tabs">
  <div class="sort-tab active" data-sort="latest">전체상품</div>
  <div class="sort-tab" data-sort="popular">구매많은 순</div>
  <div class="sort-tab" data-sort="lowprice">낮은 가격 순</div>
  <div class="sort-tab" data-sort="highprice">높은 가격 순</div>
</div>


<div id="product-list" class="product-grid">
  <!-- 결과 상품들이 동적으로 들어가는 공간 -->
  <!-- 예시 상품 카드 반복 (보통 JSTL로 forEach 돌릴 부분) -->
  <!-- 필요한 만큼 카드 복제 -->
  
  <!-- 테스트로 보여지는 용도  -->
  <!-- <div class="product-card">
    <img class="product-img" src="${cpath}/resources/images/chat_bg15.jpg" />
    <div class="product-name">상품명</div>
    <div class="product-category-list">
    <span class="product-category">소품</span>
    <span class="product-category">조명</span>
    <span class="product-category">가구</span>
  </div>
    <div class="product-price">10,000 원</div>
  </div> -->
</div>

<!-- 페이지네이션 영역 -->
	<div id="pagination" class="pagination">
		<!-- 페이지 번호가 동적으로 들어갈 자리 -->
		<!-- 한페이지에 상품 가로3개 세로 4개 총 12개, 
	  그 이상이면 페이지 이동하는 버튼 동적으로 생성 -->
		<button class="active">1</button>
		<button>2</button>
		<button>3</button>
		<button>4</button>
		<button>5</button>
	</div>

</body>
</html>