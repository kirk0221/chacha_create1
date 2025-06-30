<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<div class="header-wrapper">
  <div class="header-inner">
    <!-- 로그인 전 -->
    <div class="header-content" id="header-guest">
      <a href="${pageContext.request.contextPath}/views/member/login.jsp" class="header-btn">로그인</a>
      <span class="divider">|</span>
      <a href="${pageContext.request.contextPath}/views/member/signup.jsp" class="header-btn">회원가입</a>
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
