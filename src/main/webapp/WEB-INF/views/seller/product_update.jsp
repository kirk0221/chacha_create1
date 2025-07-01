<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뜨락상회 판매자 상품수정</title>
<%@ include file="../common/header.jsp" %>
  <link rel="stylesheet" href="${cpath}/resources/css/authmain.css">
  <link rel="stylesheet" href="${cpath}/resources/css/product_update.css">
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
			<div class="frame-1075">
				<div class="top-bar">
				  <h2>상품 상세보기</h2>
				  <div class="top-action">
				    <button class="icon-button2">
				      <iconify-icon icon="mdi:plus" class="icon-plus"></iconify-icon>
				    </button>
				  </div>
				</div>
			 <div class="form-body-row">
	          <div class="frame-1076">
				  <!-- 첫 번째 버튼에 1.jpg -->
				  <button class="frame-817-btn" type="button" aria-label="추가 버튼">
				    <img src="${cpath}/resources/images/1.jpg" alt="1번 이미지" style="width: 100%; height: 100%; object-fit: cover;" />
				  </button>
	             <div class="frame-1077">
				    <button class="frame-8152-btn">
				      <img src="${cpath}/resources/images/2.jpg" alt="2번 이미지" style="width: 100%; height: 100%; object-fit: cover;" />
				    </button>
				    <button class="frame-8152-btn">
				      <img src="${cpath}/resources/images/3.jpg" alt="3번 이미지" style="width: 100%; height: 100%; object-fit: cover;" />
				    </button>
				  </div>
				<div class="frame-1078">
				  <button class="icon-button">
				    <iconify-icon icon="mdi:menu" class="icon-menu"></iconify-icon>
				  </button>
				  <button class="icon-button">
				    <iconify-icon icon="mdi:menu" class="icon-menu"></iconify-icon>
				  </button>
				</div>
	          </div>
	          <div class="frame-1196">
	            <div class="frame-1079">
	              <div class="text-area">
					  <div class="div17">상품 이름</div>
					  <input type="text" class="box" value="짱구네 키링"/>
					  <div class="counter-low">
					    <div class="_12">1</div>
					    <div class="_100">/50</div>
					  </div>
					</div>
	              <div class="text-input">
					  <div class="div17">상품 가격</div>
					  <input type="number" class="box2" value="999999"/>
					</div>
	              <div class="text-area2">
				  <div class="div17">상품 설명</div>
<textarea class="box">
안녕하세요 33 짱구네 키링이예요~~
현재 있는 재고:
- 짱구
- 맹구
- 흰둥이
</textarea>
				  <div class="counter-low">
				    <div class="_12">1</div>
				    <div class="_100">/3000</div>
				  </div>
				</div>
	              <div class="group-90">
	                <div class="div20">상품 카테고리</div>
						<div class="frame-10772">
						  <div class="frame-8153">
						    <select class="category-select">
						      <option selected disabled>대분류 선택</option>
						      <option selected>금속공예</option>
						      <option>목공예</option>
						      <option>도자기공예</option>
						      <option>유리공예</option>
						      <option>가죽공예</option>
						      <option>레진공예</option>
						      <option>식물공예</option>
						      <option>뜨개질공예</option>
						      <option>양재공예</option>
						      <option>기타</option>
						    </select>
						  </div>
						  <div class="frame-816">
						    <select class="category-select">
						      <option selected disabled>중분류 선택</option>
						      <option selected>공예</option>
						      <option>패션잡화</option>
						      <option>인테리어 소품</option>
						      <option>악세서리</option>
						      <option>생활잡화</option>
						      <option>기타</option>
						    </select>
						  </div>
						  <div class="frame-8172">
						    <select class="category-select">
						      <option selected disabled>소분류 선택</option>
						      <option selected>상의</option>
						      <option>하의</option>
						      <option>가방</option>
						      <option>지갑</option>
						      <option>기타(목도리, 모자, 벨트 등)</option>
						    </select>
						  </div>
						</div>
	                </div>
	              <div class="text-input">
					  <div class="div17">상품 재고수량</div>
					  <input type="number" class="box2" value="5"/>
					</div>
	              </div>
	              <div class="frame-774">
				  <div class="button2-wrapper">
				    <!-- 수정 버튼 -->
				    <button class="edit-button">수정</button>
				
				    <!-- 저장 버튼 -->
				    <button class="save-button">저장</button>
				  </div>
				</div>
        	</div>
      </main>
    </div>
  </div>

  <footer>&copy; 2025 뜨락상회</footer>
</div>
</body>
</html>