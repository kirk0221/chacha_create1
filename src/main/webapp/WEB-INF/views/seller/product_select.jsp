<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>뜨락상회 판매자 상품조회</title>
<link rel="stylesheet" type="text/css" href="resources/css/authmain.css">
<link rel="stylesheet" type="text/css" href="resources/css/product_select.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://code.iconify.design/iconify-icon/1.0.8/iconify-icon.min.js"></script>
</head>
<body>
<div class="wrapper">
  <header>
    <div class="header-inner">
      <div class="login-bar">
        <span>수제대추고님 반갑습니다.</span>
        <button class="logout-btn">로그아웃</button>
      </div>
    </div>
  </header>

  <div class="main-area">
    <div class="content-wrapper">
      <nav class="sidebar">
		  <div class="profile-section" onclick="#" role="button" tabindex="0" aria-label="스토어관리 페이지로 이동">
		    <img src="_11.png" class="profile-img" />
		    <div class="store-name">수제대추고</div>
		  </div>
		  <ul class="menu-list">
		    <li><a href="#"><span class="menu-text">상품등록</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">판매상품관리</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">주문/발송확인(취소/환불)</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">환불관리</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">정산관리</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">문의메시지</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">리뷰관리</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">스토어관리</span><span class="arrow">></span></a></li>
		  </ul>
		  <div class="sidebar-footer">
		    <button class="btn-go-buyer" onclick="#">구매자페이지 이동</button>
		  </div>
		</nav>

      <main class="content">
        <div class="content-inner">
		  <h2>상품조회</h2>
		
		    <div class="button-wrapper">
		      <button class="edit-button">수정</button>
		      <button class="save-button">삭제하기</button>
		    </div>
		
		    <!-- 👇 표를 감싸는 스크롤 영역 -->
		    <div class="table-frame">
		      <table class="product-table">
		        <thead>
		          <tr>
		            <th>대표이미지</th>
		            <th>상품이름</th>
		            <th>상품가격</th>
		            <th>재고수량</th>
		            <th>대분류<br>카테고리</th>
		            <th>중분류<br>카테고리</th>
		            <th>소분류<br>카테고리</th>
		            <th>등록일</th>
		            <th>수정일</th>
		            <th>대표상품<br>(3개)</th>
		            <th>삭제하기</th>
		          </tr>
		        </thead>
		        <tbody>
		          <tr>
		            <td><img src="resources/images/1.jpg" alt="대표이미지" /></td>
		            <td>짱구네 키링</td>
		            <td>999999</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>공예</td>
		            <td>상의</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/1.jpg" alt="대표이미지" /></td>
		            <td>짱구네 키링</td>
		            <td>999999</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>공예</td>
		            <td>상의</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/1.jpg" alt="대표이미지" /></td>
		            <td>짱구네 키링</td>
		            <td>999999</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>공예</td>
		            <td>상의</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/1.jpg" alt="대표이미지" /></td>
		            <td>짱구네 키링</td>
		            <td>999999</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>공예</td>
		            <td>상의</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/1.jpg" alt="대표이미지" /></td>
		            <td>짱구네 키링</td>
		            <td>999999</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>공예</td>
		            <td>상의</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/2.jpg" alt="대표이미지" /></td>
		            <td>맹구네 키링</td>
		            <td>33,000</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>패션잡화</td>
		            <td>가방</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/2.jpg" alt="대표이미지" /></td>
		            <td>맹구네 키링</td>
		            <td>33,000</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>패션잡화</td>
		            <td>가방</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/2.jpg" alt="대표이미지" /></td>
		            <td>맹구네 키링</td>
		            <td>33,000</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>패션잡화</td>
		            <td>가방</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/2.jpg" alt="대표이미지" /></td>
		            <td>맹구네 키링</td>
		            <td>33,000</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>패션잡화</td>
		            <td>가방</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/2.jpg" alt="대표이미지" /></td>
		            <td>맹구네 키링</td>
		            <td>33,000</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>패션잡화</td>
		            <td>가방</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/3.jpg" alt="대표이미지" /></td>
		            <td>흰둥이네 키링</td>
		            <td>33,000</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>패션잡화</td>
		            <td>가방</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/3.jpg" alt="대표이미지" /></td>
		            <td>흰둥이네 키링</td>
		            <td>33,000</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>패션잡화</td>
		            <td>가방</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/3.jpg" alt="대표이미지" /></td>
		            <td>흰둥이네 키링</td>
		            <td>33,000</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>패션잡화</td>
		            <td>가방</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/3.jpg" alt="대표이미지" /></td>
		            <td>흰둥이네 키링</td>
		            <td>33,000</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>패션잡화</td>
		            <td>가방</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		          <tr>
		            <td><img src="resources/images/3.jpg" alt="대표이미지" /></td>
		            <td>흰둥이네 키링</td>
		            <td>33,000</td>
		            <td>5</td>
		            <td>금속공예</td>
		            <td>패션잡화</td>
		            <td>가방</td>
		            <td>2025-06-28</td>
		            <td>2025-06-28</td>
		            <td><input type="checkbox" /></td>
		            <td><input type="checkbox" /></td>
		          </tr>
		        </tbody>
		      </table>
		    </div>
		  </div>
      </main>
    </div>
  </div>

  <footer>&copy; 2025 뜨락상회</footer>
</div>
</body>
</html>