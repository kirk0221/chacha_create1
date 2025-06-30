<!-- ✅ JSP: 회원가입 완료 표시 추가 (기존 JSP 구조 유지하면서 "완료" 표시 추가)-->
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>
<link rel="stylesheet" type="text/css"
	href="${cpath}/resources/css/join/complete.css">
</head>
<body>
	<div class="container">
		<!-- 상단 배너 -->
		<div class="header-banner">
			<div class="header-content">
				<div class="logo-title-wrapper">
					<img class="logo" src="${cpath}/resources/images/logo.png" />
					<div class="page-title">회원가입하기</div>
				</div>
				<img class="header-illustration"
					src="${cpath}/resources/images/illustration.png" />
			</div>
		</div>

		<!-- 메인 컨텐츠 -->
		<div class="main-wrapper">
			<!-- 가입 단계 -->
			<div class="step-indicator">
				<div class="step">
					01 <br /> 약관동의
				</div>
				<img class="arrow" src="${cpath}/resources/images/arrow-right.svg" />
				<div class="step">
					02 <br /> 회원정보입력
				</div>
				<img class="arrow" src="${cpath}/resources/images/arrow-right.svg" />
				<div class="step current">
					<span><span class="step-num">03<br /></span><span
						class="step-label">완료</span></span>
				</div>
				<img class="arrow" src="${cpath}/resources/images/arrow-right.svg" />
				<div class="step">
					01 <br /> 판매자정보입력
				</div>
			</div>

			<!-- ✅ 추가된 회원가입 완료 안내 영역 -->
			<div class="complete-box">
				<div class="check-icon">✔</div>
				<div class="complete-title">회원가입 완료</div>
				<div class="complete-msg">차차님! 반갑습니다.</div>
				<button class="btn-move" onclick="location.href='${cpath}/home'">
					쇼핑몰 이동하기</button>
			</div>
		</div>
	</div>
</body>
</html>