<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>결제 완료</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/store/buyer/orderComplete.css" />
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Poppins', sans-serif;
      background: #fff;
      display: flex;
      justify-content: center;
    }

    .order-complete-container {
      width: 100%;
      max-width: 1200px;
      padding: 60px 20px;
      display: flex;
      flex-direction: column;
      align-items: center;
      gap: 40px;
    }

    .complete-icon {
      width: 100px;
      height: 100px;
    }

    .complete-message {
      font-size: 28px;
      font-weight: 600;
      color: #000;
    }

    .order-number {
      font-size: 18px;
      color: #3b82f6;
    }

    .section {
      width: 100%;
      background: #f9f9f9;
      border: 1px solid #ddd;
      border-radius: 8px;
      padding: 30px;
      display: flex;
      flex-direction: column;
      gap: 16px;
    }

    .section-title {
      font-size: 22px;
      font-weight: 600;
      border-bottom: 2px solid #000;
      padding-bottom: 10px;
    }

    .product-info {
      display: flex;
      align-items: center;
      gap: 20px;
    }

    .product-info img {
      width: 100px;
      height: 100px;
      object-fit: cover;
    }

    .product-details {
      display: flex;
      flex-direction: column;
      gap: 4px;
    }

    .product-details span {
      font-size: 16px;
    }

    .horizontal-sections {
      display: flex;
      gap: 20px;
      width: 100%;
    }

    .info-box {
      flex: 1;
      background: #fff;
      border: 1px solid #ddd;
      border-radius: 8px;
      padding: 20px;
    }

    .info-box-title {
      font-size: 20px;
      font-weight: 600;
      margin-bottom: 16px;
    }

    .info-row {
      display: flex;
      justify-content: space-between;
      margin-bottom: 10px;
    }

    .info-label {
      font-weight: 500;
      color: #333;
    }

    .info-value {
      color: #000;
    }
  </style>
</head>
<body>
  <div class="order-complete-container">
    <img class="complete-icon" src="checkmark-circle-fill0.svg" alt="완료 아이콘" />
    <div class="complete-message">주문이 완료되었습니다</div>
    <div class="order-number">주문번호: <span>2506170101</span></div>

    
	<div class="order-section">
	  <div class="section-header">
	    <h2>주문 상품</h2>
	    <button class="section-more">&gt;</button>
	  </div>
	
	  <div class="order-grid order-header">
	    <div></div> <!-- 이미지 자리 비움 -->
	    <div>상품명</div>
	    <div>수량</div>
	    <div>가격</div>
	  </div>
	
	  <div class="order-grid order-item">
	    <img src= "${pageContext.request.contextPath}/resources/img/home.jpg"  alt="상품 이미지" class="product-image" />
	    <div>차차크리에이트</div>
	    <div>1</div>
	    <div>500,000 원</div>
	  </div>
	</div>

    

    <div class="horizontal-sections">
      <div class="info-box">
        <div class="info-box-title">배송지 정보</div>
        <div class="info-row">
          <span class="info-label">이름</span>
          <span class="info-value">안세현</span>
        </div>
        <div class="info-row">
          <span class="info-label">전화번호</span>
          <span class="info-value">01012345678</span>
        </div>
        <div class="info-row">
          <span class="info-label">주소</span>
          <span class="info-value">어쩌구 개미 마포구 허리도 가늘군 만지면 부러지리</span>
        </div>
      </div>

      <div class="info-box">
        <div class="info-box-title">결제 정보</div>
        <div class="info-row">
          <span class="info-label">상품 금액</span>
          <span class="info-value">500,000 원</span>
        </div>
        <div class="info-row">
          <span class="info-label">배송비</span>
          <span class="info-value">999,999 원</span>
        </div>
        <div class="info-row">
          <span class="info-label">총 결제</span>
          <span class="info-value">1억 카드 결제</span>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
