<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main_style.css">
</head>
<body>
<div class="div">

  <div class="div2">
    <div class="div3"></div>
    <a href="${pageContext.request.contextPath}/views/member/login.jsp"  class="div4">로그인</a>
    <a href="${pageContext.request.contextPath}/views/member/signup.jsp" class="div5">회원가입</a>
    <div class="div6">|</div>
  </div>
  
  
  
  <div class="nav">
    <a href="${pageContext.request.contextPath}/views/main/mian.jsp">
        <img class="rectangle-458" src="${pageContext.request.contextPath}/resources/images/logo/logo_green.png" />
    </a>
    <a href="${pageContext.request.contextPath}/views/main/main_allproducts.jsp" class="div7">전체 상품</a>
    <a href="${pageContext.request.contextPath}/views/main/main_store.jsp" class="div7">스토어</a>
    <a href="${pageContext.request.contextPath}/views/main/main_notice.jsp" class="div7">공지 / 소식</a>
    <a href="${pageContext.request.contextPath}/views/main/main_personal_sale.jsp" class="div7">개인 판매</a>
    <a href="${pageContext.request.contextPath}/views/main/main_class.jsp" class="div7">클래스</a>
    <a href="${pageContext.request.contextPath}/views/main/main_mypage.jsp" class="div7">마이페이지</a>
    <div>
    <a href="${pageContext.request.contextPath}/views/main/cart.jsp" >
        <div class="cart-flex">
            <img class="group" src="${pageContext.request.contextPath}/resources/images/main/main_nav_shop.png" />
            <span class="div7">장바구니</span>
        </div>
    </a>
</div>
</div>

  <div class="widgets">
    <div class="widget">
      <div class="dot">
        <div class="_03"></div>
        <div class="_02"></div>
        <div class="_01"></div>
      </div>
      <div class="content">
        <div class="content2">
          <div class="heading">
            <div class="caption">
              <div class="devider"></div>
              <div class="the-best-place-to-play">THE BEST PLACE TO PLAY</div>
            </div>
            <div class="xbox-consoles">Xbox Consoles</div>
          </div>
          <div class="save-up-to-50-on-select-xbox-games-get-3-months-of-pc-game-pass-for-2-usd">
            Save up to 50% on select Xbox games. Get 3 months of PC Game Pass for $2 USD.
          </div>
        </div>
        <div class="button">
          <div class="label">Shop Now</div>
          <img class="regular-arrow-right" src="${pageContext.request.contextPath}/images/regular-arrow-right0.svg" />
        </div>
      </div>
      <img class="image" src="${pageContext.request.contextPath}/images/image0.png" />
      <div class="price">
        <div class="_299">$299</div>
      </div>
    </div>

    <!-- Small widgets -->
    <div class="small-widgets">
      <div class="widget2">
        <div class="badge">
          <div class="_29-off">29% OFF</div>
        </div>
        <div class="content3">
          <div class="info">
            <div class="summer-sales">Summer Sales</div>
            <div class="new-google-pixel-6-pro">New Google Pixel 6 Pro</div>
          </div>
          <div class="button2">
            <div class="label2">Shop Now</div>
            <img class="regular-arrow-right2" src="${pageContext.request.contextPath}/images/regular-arrow-right1.svg" />
          </div>
        </div>
      </div>
      
      <div class="widget3">
        <img class="image-4" src="${pageContext.request.contextPath}/images/image-40.png" />
        <div class="content4">
          <div class="info2">
            <div class="xiaomi-flip-buds-pro">Xiaomi FlipBuds Pro</div>
            <div class="_299-usd">$299 USD</div>
          </div>
          <div class="button2">
            <div class="label2">Shop Now</div>
            <img class="regular-arrow-right3" src="${pageContext.request.contextPath}/images/regular-arrow-right2.svg" />
          </div>
        </div>
      </div>
    </div>
  </div>

<!-- 인기 스토어 영역 -->
 <div class="div9">
    <div class="fram">
      <img class="line-md-star-filled" src="${pageContext.request.contextPath}/resources/images/main/main_contour_star.png" />
      <div class="div10">인기 스토어</div>
    </div>
  </div>
  
  
  <div class="div11">
  <button id="slideLeft" class="slide-btn">
    <img class="weui-arrow-filled" src="${pageContext.request.contextPath}/resources/images/main/main_slide_left.png" />
  </button>

 <div class="slider-container">
  <div class="frame-95" id="store-slider">
    <%@ include file="popularStores.jspf" %>
  </div>
  </div>

  <button id="slideRight" class="slide-btn">
    <img class="weui-arrow-filled" src="${pageContext.request.contextPath}/resources/images/main/main_slide_right.png" />
  </button>
</div>
  
  
   <div class="div9">
    <div class="fram">
      <img class="line-md-star-filled" src="${pageContext.request.contextPath}/resources/images/main/main_contour_star.png" />
      <div class="div10">인기 상품</div>
    </div>
  </div>
  
  <div class="div17">
    <div class="div12">
       <img class="weui-arrow-filled" src="${pageContext.request.contextPath}/resources/images/main/main_slide_left.png" />
    </div>
    <div class="frame-95">
      <div class="div18">
        <img class="rectangle-4662" src="rectangle-4663.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
      <div class="div18">
        <img class="rectangle-4663" src="rectangle-4664.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
      <div class="div18">
        <img class="rectangle-4663" src="rectangle-4665.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
      <div class="div18">
        <img class="rectangle-4663" src="rectangle-4666.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
    </div>
    <div class="div21">
      <img class="weui-arrow-filled" src="${pageContext.request.contextPath}/resources/images/main/main_slide_right.png" />
    </div>
  </div>
   <div class="div9" style="background-color:#F5F2EB; ">
    <div class="fram">
      <img class="line-md-star-filled" src="${pageContext.request.contextPath}/resources/images/main/main_contour_star.png" />
      <div class="div10">금주 신상품</div>
    
  </div>
  </div>
  <div class="div22">
    <div class="frame-953">
      <div class="div23">금주 신상품 전체보기 →</div>
    </div>
    <div class="frame-954">
      <div class="div18">
        <img class="rectangle-4662" src="rectangle-4667.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
      <div class="div18">
        <img class="rectangle-4662" src="rectangle-4668.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
      <div class="div18">
        <img class="rectangle-4662" src="rectangle-4669.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
      <div class="div18">
        <img class="rectangle-4662" src="rectangle-46610.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
      <div class="div18">
        <img class="rectangle-4662" src="rectangle-46611.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
      <div class="div18">
        <img class="rectangle-4662" src="rectangle-46612.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
      <div class="div18">
        <img class="rectangle-4662" src="rectangle-46613.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
      <div class="div18">
        <img class="rectangle-4662" src="rectangle-46614.png" />
        <div class="div19">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div20">
            <div class="_10-000">10,000</div>
            <div class="div10">원</div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="footer">
    <div class="frame-955">
      <div class="frame-956">
        <img class="rectangle-4582" src="rectangle-4581.svg" />
        <div class="div24">뜨락상회</div>
      </div>
      <div class="div25">
        이것은 뜨락 상회에 대해 설명하는
        <br />
        설명칸이로다 아아ㅏ아아아아아아아아ㅏㅇ
        <br />
        아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
      </div>
      <div class="frame-957">
        <div class="frame-958">
          <div class="rectangle-468"></div>
        </div>
        <div class="div26">연락처</div>
      </div>
      <div class="frame-1063">
        <div class="frame-958">
          <div class="rectangle-468"></div>
        </div>
        <div class="_22">연락처2</div>
      </div>
      </div>
      </div>
      
</div>
<script src="${pageContext.request.contextPath}/resources/js/slide.js"></script>
</body>
</html>
