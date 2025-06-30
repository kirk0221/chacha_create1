<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />


<div class="header-wrapper">
  <div class="header-inner">
    <!-- 로그인 전 -->
    <div class="header-content" id="header-guest">
	  <a href="${cpath}/main/login" class="header-btn">로그인</a>
	  <span class="divider">|</span>
	  <a href="${cpath}/main/signup" class="header-btn">회원가입</a>
	</div>

    <!-- 로그인 후 -->
    <div class="header-content" id="header-user" style="display: none;">
      <span class="welcome-text"><span id="member-name">000</span>님 반갑습니다!</span>
      <a href="#" class="header-btn">메시지</a>
      <a href="#" class="header-btn">로그아웃</a>
    </div>
  </div>
</div>

<style>

html, body {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
.header-wrapper {
  width: 100%;
  height: 50px;
  background: #2D4739;
  display: flex;
  justify-content: center;
  align-items: center;
}

.header-inner {
  width: 1920px;
  padding: 0 240px;
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

.header-content {
  display: flex;
  align-items: center;
  gap: 20px;
}

.header-btn, .welcome-text, .divider {
  color: #ffffff;
  font-size: 16px;
  text-decoration: none;
  cursor: pointer;
  font-family: 'Jua', sans-serif;
}
</style>
