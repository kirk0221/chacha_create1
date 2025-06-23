<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>전체 상품 페이지</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main_allproducts.css">
</head>
<body>
<div class="div">

  <!-- 상단 로그인 영역 -->
  <div class="div2">
    <div class="frame-1000">
      <div class="group-58">
        <div class="div3"></div>
      </div>
      <div class="group-60">
        <div class="rectangle-439"></div>
        <div class="div4">메시지</div>
        <div class="div5">로그아웃</div>
        <div class="div6">
          <span>
            <span class="div-6-span">김지민 바보^^*님</span>
            <span class="div-6-span2">반갑습니다!</span>
          </span>
        </div>
      </div>
    </div>
  </div>

  <!-- 네비게이션 -->
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

  <!-- 카테고리 썸네일 -->
  <div class="frame-98">
    <div class="frame-1195">
      <div class="frame-982">
        <img class="ellipse-502" src="${pageContext.request.contextPath}/resources/images/ellipse-5020.png" />
        <div class="div10">패션소품</div>
      </div>
      <div class="frame-982">
        <img class="ellipse-502" src="${pageContext.request.contextPath}/resources/images/ellipse-5021.png" />
        <div class="div10">홈리빙</div>
      </div>
      <div class="frame-982">
        <img class="ellipse-502" src="${pageContext.request.contextPath}/resources/images/ellipse-5022.png" />
        <div class="div10">생활잡화</div>
      </div>
      <div class="frame-982">
        <img class="ellipse-502" src="${pageContext.request.contextPath}/resources/images/ellipse-5023.png" />
        <div class="div10">인형. 장식소품</div>
      </div>
      <div class="frame-982">
        <img class="ellipse-502" src="${pageContext.request.contextPath}/resources/images/ellipse-5024.png" />
        <div class="div10">문구.페이퍼굿즈</div>
      </div>
      <!-- 나머지 추가 이미지도 동일하게 넣어주면 됩니다 -->
    </div>
  </div>

  <!-- 상세 카테고리 -->
  <div class="frame-983">
    <div class="div11">상세카테고리</div>
    <div class="frame-93">
      <div class="frame-932"><div class="_1">카테고리1</div></div>
      <div class="frame-10642"><div class="_2">카테고리2</div></div>
      <div class="frame-10662"><div class="_2">카테고리2</div></div>
      <div class="frame-10672"><div class="_2">카테고리2</div></div>
      <div class="frame-10652"><div class="_3">카테고리3</div></div>
    </div>
  </div>

  <!-- 상품 리스트 -->
  <div class="heading">
    <div class="left-contents">
      <div class="tab">
        <div class="tab2"><div class="active">전체상품</div></div>
        <div class="tab3"><div class="normal">구매많은 순</div></div>
        <div class="tab3"><div class="normal">평점순</div></div>
        <div class="tab3"><div class="normal">낮은 가격 순</div></div>
        <div class="tab3"><div class="normal">높은 가격 순</div></div>
      </div>
    </div>
  </div>

  <div class="frame-984">
    <div class="frame-985">
      <%-- 반복해서 상품 카드 출력 부분 --%>
      <div class="div12">
        <img class="rectangle-466" src="${pageContext.request.contextPath}/resources/images/rectangle-4660.png" />
        <div class="div13">
          <div class="div14">상품명</div>
          <div class="_12">카테고리1</div>
          <div class="div15">
            <div class="_10-000">10,000</div>
            <div class="div16">원</div>
          </div>
        </div>
      </div>
      <%-- 여기에 반복해서 상품 카드 추가 --%>
    </div>
  </div>

  <!-- 페이지네이션 -->
  <div class="frame-96">
    <div class="pagination">
      <div class="frame-153"><div class="chevron-down"><img class="group2" src="${pageContext.request.contextPath}/resources/images/group1.svg" /></div></div>
      <div class="frame-163">
        <div class="frame-155"><div class="_13">1</div></div>
        <div class="frame-156"><div class="_22">2</div></div>
        <div class="frame-157"><div class="_32">3</div></div>
        <div class="frame-158"><div class="_4">4</div></div>
        <div class="frame-159"><div class="_5">5</div></div>
        <div class="frame-160"><div class="div17">...</div></div>
        <div class="frame-161"><div class="_21">21</div></div>
      </div>
      <div class="frame-162"><div class="chevron-down"><img class="group3" src="${pageContext.request.contextPath}/resources/images/group2.svg" /></div></div>
    </div>
  </div>

  <!-- 하단 footer -->
  <div class="footer">
    <div class="frame-95">
      <div class="frame-952">
        <img class="rectangle-4582" src="${pageContext.request.contextPath}/resources/images/rectangle-4581.svg" />
        <div class="div18">뜨락상회</div>
      </div>
      <div class="div19">
        이것은 뜨락 상회에 대해 설명하는<br/>
        설명칸이로다 아아아아아아아아아아앙<br/>
        아아아아아아아아아아
      </div>
      <div class="frame-953">
        <div class="frame-954"><div class="rectangle-468"></div></div>
        <div class="div20">연락처</div>
      </div>
      <div class="frame-10632">
        <div class="frame-954"><div class="rectangle-468"></div></div>
        <div class="_23">연락처2</div>
      </div>
    </div>
  </div>

</div>
</body>
</html>
