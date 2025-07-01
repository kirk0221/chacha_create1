<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>주문/결제</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/store/buyer/order.css" />
</head>
<body>
  <div class="order-page">
    <div class="order-layout">

      <!-- 좌측: 배송지 + 주문상품 -->
      <section class="order-left">


        <!-- 배송지 -->
        <div class="block-header">
          <h2 class="block-title">배송지</h2>
          <div class="block-divider"></div>
          </div>
		<div class="order-block delivery-block">
		  <div class="delivery-info">
		    <div class="delivery-row">
		      <label for="receiverName">이름</label>
		      <input type="text" id="receiverName" name="receiverName" value="김무무" />
		    </div>
		    <div class="delivery-row">
		      <label for="receiverPhone">연락처</label>
		      <input type="text" id="receiverPhone" name="receiverPhone" value="010-1234-1234" />
		    </div>
		    <div class="delivery-row postcode-row">
		      <label for="sample6_postcode">우편번호</label>
		      <input type="text" id="sample6_postcode" name="postcode" placeholder="우편번호" readonly />
		      <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" />
		    </div>
		    <div class="delivery-row">
		      <label for="sample6_address">주소</label>
		      <input type="text" id="sample6_address" name="address" placeholder="주소" readonly />
		    </div>
		    <div class="delivery-row">
		      <label for="sample6_detailAddress">상세주소</label>
		      <input type="text" id="sample6_detailAddress" name="detailAddress" placeholder="상세주소" />
		    </div>
		    <div class="delivery-row">
		      <label for="sample6_extraAddress">참고항목</label>
		      <input type="text" id="sample6_extraAddress" name="extraAddress" placeholder="참고항목" readonly />
		    </div>
		  </div>
		</div>



        <!-- 주문 상품 -->
		<div class="block-header">
		  <h2 class="block-title">주문 상품</h2>
		  <div class="block-divider"></div>
		</div>
		<div class="order-block product-block">
		
		  <!-- 상품 1 -->
		  <div class="product-item">
		    <div class="product-box">
		      <img class="product-image" src="${pageContext.request.contextPath}/resources/img/home.jpg" alt="상품 이미지" />
		      <div class="product-info">
		        <div class="store-name">000 스토어</div>
		        <div class="product-name">
		          미백 주름 기능성 옴므 비타민C 올인원 남자로션 산뜻한 저자극 남자 스킨 150ml
		        </div>
		        <div class="product-desc"></div>
		        <div class="quantity">수량: 2개</div>
		      </div>
		      <div class="price-quantity-wrapper">
		        <div class="price">5,959 원</div>
		      </div>
		    </div>
		  </div>
		
		  <!-- 상품 2 -->
		  <div class="product-item">
		    <div class="product-box">
		      <img class="product-image" src="${pageContext.request.contextPath}/resources/img/home.jpg" alt="상품 이미지" />
		      <div class="product-info">
		        <div class="store-name">000 스토어</div>
		        <div class="product-name">
		          <strong>상품 이름</strong>
		        </div>
		        <div class="product-desc">상품 소개도 있다면 어떨까?</div>
		        <div class="quantity">수량: 2개</div>
		      </div>
		      <div class="price-quantity-wrapper">
		        <div class="price">5,959 원</div>
		      </div>
		    </div>
		  </div>
		
		</div>

      </section>

      <!-- 우측: 결제 요약 -->
      <aside class="order-summary">
        <div class="summary-title">결제 예상 금액</div>
        <div class="summary-list">
          <div class="summary-item">
            <span>상품 금액</span><span>11,918 원</span>
          </div>
          <div class="summary-item">
            <span>배송비</span><span>2,500 원</span>
          </div>
        </div>
        <div class="summary-total">
          <span>총 결제 금액</span><span class="total-price">14,418 원</span>
        </div>
        <button class="pay-button">결제하기</button>
      </aside>

    </div>
  </div>
  
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = ''; 
                var extraAddr = ''; 

                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }

                if(data.userSelectedType === 'R'){
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
  
</body>
</html>
