<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />
<c:set var="uri" value="${pageContext.request.requestURI}" />

<aside class="sidebar">
  <ul>
    <li><a href="${cpath}/main/mypage"
           class="${fn:contains(uri, '/main/mypage') and !fn:contains(uri, '/mypage/cart') and !fn:contains(uri, '/mypage/orders') and !fn:contains(uri, '/mypage/interests') and !fn:contains(uri, '/mypage/reviews') ? 'active' : ''}">
           마이정보수정</a></li>

    <li><a href="${cpath}/main/mypage/cart"
           class="${fn:contains(uri, '/mypage/cart') ? 'active' : ''}">
           장바구니</a></li>

    <li><a href="${cpath}/main/mypage/orders"
           class="${fn:contains(uri, '/mypage/orders') ? 'active' : ''}">
           주문내역</a></li>

    <li><a href="${cpath}/main/mypage/favorite"
           class="${fn:contains(uri, '/mypage/interests') ? 'active' : ''}">
           관심사 선택</a></li>

    <li><a href="${cpath}/main/mypage/myreview"
           class="${fn:contains(uri, '/mypage/reviews') ? 'active' : ''}">
           작성 리뷰 확인</a></li>
  </ul>
</aside>

<style>
.sidebar {
  width: 240px;
  background-color: #E6F1E5; /* 연한 그린 */
  padding-top: 20px;
  flex-shrink: 0;
  border-radius: 12px;
  box-shadow: 2px 2px 8px rgba(0, 64, 0, 0.05);
  height: auto;
}

.sidebar ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.sidebar ul li a {
  display: block;
  padding: 15px 20px;
  text-decoration: none;
  color: #2D4739;
  font-weight: 600;
  font-size: 15px;
  border-radius: 4px;
  transition: background-color 0.2s, color 0.2s;
}

.sidebar ul li a:hover {
  background-color: #cde4d2;
  color: #1b2e23;
}

.sidebar ul li a.active {
  background-color: #B0CBB0; /* 강조되는 초록 */
  color: #fff;
}

.sidebar ul li a.active::after {
  content: '\25B6'; /* 화살표 문자 */
  float: right;
  margin-left: 10px;
}
</style>
