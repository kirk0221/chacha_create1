<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>판매자 정보</title>
  <link rel="stylesheet" href="${cpath}/resources/css/buyer/seller_info.css">
</head>
<body>
  <div class="seller-container">

    <!-- 프로필 이미지 + 이름 -->
    <div class="profile-section">
      <img src="${cpath}/resources/images/illustration.png" alt="판매자 이미지" class="profile-img">
      <h2 class="profile-name">김무무 판매자</h2>
    </div>

    <!-- 판매자 기본 정보 -->
    <div class="info-card">
      <h3 class="section-title">기본 정보</h3>
      <div class="info-row"><span class="label">연락처</span><span class="value">010-1234-1234</span></div>
      <div class="info-row"><span class="label">이메일</span><span class="value">aaaa1234@naver.com</span></div>
    </div>

    <!-- 스토어 소개 -->
    <div class="info-card">
      <h3 class="section-title">스토어 소개</h3>
      <p class="desc-box">차차 스토어는 수공예 제품만을 정성스럽게 선별하여 판매하는 공간입니다.</p>
    </div>

    <!-- 이력 등록 -->
    <div class="info-card">
      <h3 class="section-title">나의 이력</h3>
      <ul class="history-list">
        <li>2019 - 수공예 창업</li>
        <li>2020 - 오프라인 플리마켓 10회 이상 참가</li>
        <li>2021 - SNS 팔로워 1만 돌파</li>
        <li>2022 - 차차 스토어 론칭</li>
        <li>2023 - 공방 오픈</li>
      </ul>
    </div>

  </div>
</body>
</html>
