<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스토어 목록</title>
<%@ include file="/common/header.jsp"%>
<link rel="stylesheet" href="${cpath}/resources/css/main/mainStoreList.css">
</head>
<body>

<!-- ✅ Include Header & Nav -->
<jsp:include page="/common/header.jsp" />
<jsp:include page="/common/main_nav.jsp" />

<!-- 검색창 -->
<div id="product-search">
  <form id="search-form" action="/api/main/productlist" method="get">
    <input type="text" name="query" placeholder="Search" id="search-input" />
    <button type="submit" id="search-button">🔍</button>
  </form>
</div>

<div class="store-page-container">
  <!-- 상단 탭 -->
  <div class="tab-menu">
    <span class="tab active">스토어 목록</span>
    <span class="tab">스토어 개설 설명</span>
  </div>

  <!-- 스토어 제목 -->
  <h1 class="store-title">뜨락상회 입점 스토어</h1>

  <!-- 정렬/필터 버튼 -->
  <div class="filter-buttons">
    <button class="filter-button active">최신순</button>
    <button class="filter-button">인기 상품순</button>
    <button class="filter-button">가나다순</button>
    <button class="filter-button">즐겨찾기</button>
    <button class="filter-button">카테고리별 ▼</button>
  </div>
</div>

<div id="category-section">
	<!-- 카테고리별 필터 버튼 클릭시 리스트 출력 공간 -->
	
	<!-- 테스트용 -->
  <div class="main-category-block" data-category-id="furniture">
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
</div>
<div class="main-category-block" data-category-id="lighting">
  <div class="main-category-header">
    <span class="category-name">조명</span>
    <span class="toggle-arrow">🔽</span>
    <label class="select-all"><input type="checkbox" class="check-all"> 전체 선택</label>
  </div>
</div>
<div class="main-category-block" data-category-id="lighting">
  <div class="main-category-header">
    <span class="category-name">조명</span>
    <span class="toggle-arrow">🔽</span>
    <label class="select-all"><input type="checkbox" class="check-all"> 전체 선택</label>
  </div>
</div>
<div class="main-category-block" data-category-id="lighting">
  <div class="main-category-header">
    <span class="category-name">조명</span>
    <span class="toggle-arrow">🔽</span>
    <label class="select-all"><input type="checkbox" class="check-all"> 전체 선택</label>
  </div>
</div>
<div class="main-category-block" data-category-id="lighting">
  <div class="main-category-header">
    <span class="category-name">조명</span>
    <span class="toggle-arrow">🔽</span>
    <label class="select-all"><input type="checkbox" class="check-all"> 전체 선택</label>
  </div>
</div>
<div class="main-category-block" data-category-id="lighting">
  <div class="main-category-header">
    <span class="category-name">조명</span>
    <span class="toggle-arrow">🔽</span>
    <label class="select-all"><input type="checkbox" class="check-all"> 전체 선택</label>
  </div>
</div>

<!-- 검색 버튼 -->
  <div class="category-search-btn-wrapper">
    <button type="button" class="category-search-btn">검색하기</button>
  </div>
  </div>


<!--  스토어 목록 -->
<div class="store-grid-container">
  <!-- store-card는 반복 요소 -->
<!-- 스토어 정보 섹션이 들어가는 곳 -->

<!-- 테스트용 -->
  <div class="store-card">
    <div class="store-image"><img class="product-img" src="${cpath}/resources/images/chat_bg3.jpg" /></div> <!-- 대표 이미지 -->
    <div class="store-content">
      <h2 class="store-name">스토어명</h2>
      <div class="store-categories">
        <span class="category">카테고리1</span>
        <span class="category">카테고리2</span>
        <span class="category">카테고리3</span>
      </div>
      <div class="store-description">
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명
      </div>
    </div>
  </div>

  <div class="store-card">
    <div class="store-image"><img class="product-img" src="${cpath}/resources/images/chat_bg3.jpg" /></div> <!-- 대표 이미지 -->
    <div class="store-content">
      <h2 class="store-name">스토어명</h2>
      <div class="store-categories">
        <span class="category">카테고리1</span>
        <span class="category">카테고리2</span>
        <span class="category">카테고리3</span>
      </div>
      <div class="store-description">
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명
      </div>
    </div>
  </div>

  <div class="store-card">
    <div class="store-image"><img class="product-img" src="${cpath}/resources/images/chat_bg3.jpg" /></div> <!-- 대표 이미지 -->
    <div class="store-content">
      <h2 class="store-name">스토어명</h2>
      <div class="store-categories">
        <span class="category">카테고리1</span>
        <span class="category">카테고리2</span>
        <span class="category">카테고리3</span>
      </div>
      <div class="store-description">
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명
      </div>
    </div>
  </div>

  <div class="store-card">
    <div class="store-image"><img class="product-img" src="${cpath}/resources/images/chat_bg3.jpg" /></div> <!-- 대표 이미지 -->
    <div class="store-content">
      <h2 class="store-name">스토어명</h2>
      <div class="store-categories">
        <span class="category">카테고리1</span>
        <span class="category">카테고리2</span>
        <span class="category">카테고리3</span>
      </div>
      <div class="store-description">
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명
      </div>
    </div>
  </div>

  <div class="store-card">
    <div class="store-image"><img class="product-img" src="${cpath}/resources/images/chat_bg3.jpg" /></div> <!-- 대표 이미지 -->
    <div class="store-content">
      <h2 class="store-name">스토어명</h2>
      <div class="store-categories">
        <span class="category">카테고리1</span>
        <span class="category">카테고리2</span>
        <span class="category">카테고리3</span>
      </div>
      <div class="store-description">
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명
      </div>
    </div>
  </div>

  <div class="store-card">
    <div class="store-image"><img class="product-img" src="${cpath}/resources/images/chat_bg3.jpg" /></div> <!-- 대표 이미지 -->
    <div class="store-content">
      <h2 class="store-name">스토어명</h2>
      <div class="store-categories">
        <span class="category">카테고리1</span>
        <span class="category">카테고리2</span>
        <span class="category">카테고리3</span>
      </div>
      <div class="store-description">
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명
      </div>
    </div>
  </div>

  <div class="store-card">
    <div class="store-image"><img class="product-img" src="${cpath}/resources/images/chat_bg3.jpg" /></div> <!-- 대표 이미지 -->
    <div class="store-content">
      <h2 class="store-name">스토어명</h2>
      <div class="store-categories">
        <span class="category">카테고리1</span>
        <span class="category">카테고리2</span>
        <span class="category">카테고리3</span>
      </div>
      <div class="store-description">
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명
      </div>
    </div>
  </div>

  <div class="store-card">
    <div class="store-image"><img class="product-img" src="${cpath}/resources/images/chat_bg3.jpg" /></div> <!-- 대표 이미지 -->
    <div class="store-content">
      <h2 class="store-name">스토어명</h2>
      <div class="store-categories">
        <span class="category">카테고리1</span>
        <span class="category">카테고리2</span>
        <span class="category">카테고리3</span>
      </div>
      <div class="store-description">
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명
      </div>
    </div>
  </div>

  <div class="store-card">
    <div class="store-image"><img class="product-img" src="${cpath}/resources/images/chat_bg3.jpg" /></div> <!-- 대표 이미지 -->
    <div class="store-content">
      <h2 class="store-name">스토어명</h2>
      <div class="store-categories">
        <span class="category">카테고리1</span>
        <span class="category">카테고리2</span>
        <span class="category">카테고리3</span>
      </div>
      <div class="store-description">
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명<br>
        블라블라 스토어 간단한 설명
      </div>
    </div>
  </div>

</div>

<!-- 페이지네이션 영역 -->
<div id="pagination" class="pagination">
	  <!-- 페이지 번호가 동적으로 들어갈 자리 -->
	  <!-- 한페이지에 상품 가로3개 세로 4개 총 12개, 
	  그 이상이면 페이지 이동하는 버튼 동적으로 생성 
	  < button >&lt;</ button >  : 첫 페이지 이동
       - < button >1</ button > : 최대 5개까지
       - < button >&gt;</ button >  : 다음 페이지 그룹 또는 마지막 페이지 이동-->
</div>
	  
	  <!-- 테스트 용도 -->
	  <div id="pagination" class="pagination">
		  <button class="active">1</button>
		  <button>2</button>
		  <button>3</button>
		  <button>4</button>
		  <button>5</button>
		</div>



</body>
</html>