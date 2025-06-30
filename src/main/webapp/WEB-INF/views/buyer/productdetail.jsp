<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>상품 상세 페이지</title>
  <%@ include file="../common/header.jsp" %>
  <link rel="stylesheet" href="${cpath}/resources/css/productdetail.css">
</head>
<body>
<div class="div">

  <!-- 상품 상세 섹션 -->
  <div class="product-section">
    <!-- 왼쪽: 이미지 -->
    <div class="media-gallery">
      <div class="main-image">
        <img src=" ${pageContext.request.contextPath}/resources/img/home.jpg" alt="메인 이미지" />
      </div>
      <div class="thumbnail-row">
        <img src=" ${pageContext.request.contextPath}/resources/img/home.jpg" alt="썸네일1" class="thumbnail" />
        <img src=" ${pageContext.request.contextPath}/resources/img/coffee.jpg" alt="썸네일2" class="thumbnail" />
        <img src=" ${pageContext.request.contextPath}/resources/img/home.jpg" alt="썸네일3" class="thumbnail" />
      </div>
    </div>

    <!-- 오른쪽: 정보 -->
    <div class="product-details">
      <div class="store-name">스토어 이름</div>
      <div class="product-title-row">
        <div class="product-title">집 가기 티켓</div>
        <button class="like-button">❤️</button>
      </div>
      <div class="product-category">카테고리 1</div>
      <div class="product-quantity">
        <label class="quantity-label">수량</label>
        <div class="quantity-control">
          <button class="quantity-btn">-</button>
          <div class="quantity-display">1</div>
          <button class="quantity-btn">+</button>
        </div>
        <div class="product-price">500,000 원</div>
      </div>
      <div class="action-buttons">
      <button class="cart-button">장바구니 담기</button>
        <button class="buy-button">결제하기</button>
      </div>
    </div>
  </div>

  <!-- 구분선 및 상세 설명 -->
  <div class="detail-text-img">
  <h1>상품 디테일</h1>
    <div class="img-ex">
      <img class="detail-img1" src=" ${pageContext.request.contextPath}/resources/img/home.jpg" />
      <img class="detail-img2" src="${pageContext.request.contextPath}/resources/img/home.jpg"/>
    </div>
    <div class="detail-text">
      <span>
        <span class="detail-text-middle">
          <b>네 그래요 이건 집 가기 티켓입니다</b>
        </span>
        <span class="detail-text-small">
          어쩌구저쩌구입니다다다다<br>
          여기는 방이 좋고 어쩌구...<br>
          짱! 글이 더 길기는 할 텐데<br>
          머라 쓰냐 예시를<br>
          이 상품은 누구나 가지고 싶어 하는<br>
          이 정도면 예시로 됐나
        </span>
      </span>
    </div>
  </div>
  
  <!-- 리뷰 섹션 -->
	<div class="review-section">
	  <h2>리뷰</h2>
	
	  <!-- 리뷰 작성 폼 -->
	  <div class="review-form">
	    <textarea class="review-input" placeholder="리뷰를 입력하세요!!"></textarea>
	    <button class="review-submit-btn">등록</button>
	  </div>
	
	  <!-- 리뷰 목록 -->
	  <div class="review-list">
	    <!-- 예시 리뷰 -->
		<div class="review-item">
		  <div class="review-header">
		    <div class="review-meta">
		      <span class="review-writer">재희</span>
		      <span class="review-date">2025-06-27</span>
		    </div>
		    <div class="review-buttons">
		      <button class="review-edit-btn">수정</button>
		      <button class="review-delete-btn">삭제</button>
		    </div>
		  </div>
		  <div class="review-content">에바네요..</div>
		</div>
		
		<div class="review-item">
		  <div class="review-header">
		    <div class="review-meta">
		      <span class="review-writer">윤정</span>
		      <span class="review-date">2025-06-26</span>
		    </div>
		    <div class="review-buttons">
		      <button class="review-report-btn">신고</button>
		    </div>
		  </div>
		  <div class="review-content">이거 완전 좋음! 강추함!!</div>
		</div>

	  </div>
	</div>

  
</div>

<script>
document.addEventListener("DOMContentLoaded", function () {
  // 👉 썸네일 클릭 시 메인 이미지 변경
  const mainImage = document.querySelector(".main-image img");
  const thumbnails = document.querySelectorAll(".thumbnail");

  if (thumbnails.length > 0) {
    mainImage.src = thumbnails[0].src; // 첫 번째 썸네일을 기본 메인 이미지로 설정
  }

  thumbnails.forEach(thumbnail => {
    thumbnail.addEventListener("click", () => {
      mainImage.src = thumbnail.src;
    });
  });

  // 👉 리뷰 버튼 이벤트 연결
  function bindReviewEvents(container) {
    const editBtn = container.querySelector(".review-edit-btn");
    const deleteBtn = container.querySelector(".review-delete-btn");

    if (editBtn) {
      editBtn.addEventListener("click", function () {
        const content = container.querySelector(".review-content").textContent.trim();
        container.querySelector(".review-content").style.display = "none";

        const buttonsDiv = container.querySelector(".review-buttons");
        buttonsDiv.innerHTML = `
          <button class="review-save-btn">저장</button>
          <button class="review-cancel-btn">취소</button>
        `;

        const textarea = document.createElement("textarea");
        textarea.className = "review-edit-input";
        textarea.value = content;
        container.appendChild(textarea);

        buttonsDiv.querySelector(".review-save-btn").addEventListener("click", function () {
          const newContent = textarea.value.trim();
          container.querySelector(".review-content").textContent = newContent;
          container.querySelector(".review-content").style.display = "block";
          textarea.remove();
          restoreButtons(container);
        });

        buttonsDiv.querySelector(".review-cancel-btn").addEventListener("click", function () {
          container.querySelector(".review-content").style.display = "block";
          textarea.remove();
          restoreButtons(container);
        });
      });
    }

    if (deleteBtn) {
      deleteBtn.addEventListener("click", function () {
        container.remove(); // 삭제
      });
    }
  }

  function restoreButtons(container) {
    const buttonsDiv = container.querySelector(".review-buttons");
    buttonsDiv.innerHTML = `
      <button class="review-edit-btn">수정</button>
      <button class="review-delete-btn">삭제</button>
    `;
    bindReviewEvents(container);
  }

  // 초기 리뷰 이벤트 바인딩
  document.querySelectorAll(".review-item").forEach(item => bindReviewEvents(item));
});
</script>


</body>
</html>
