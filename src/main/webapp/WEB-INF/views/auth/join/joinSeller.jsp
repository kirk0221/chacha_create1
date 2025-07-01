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
	href="${cpath}/resources/css/auth/join/joinSeller.css">
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
				<div class="step">
					03 <br /> 완료
				</div>
				<img class="arrow" src="${cpath}/resources/images/arrow-right.svg" />
				<div class="step current">
					<span><span class="step-num">01<br /></span><span
						class="step-label">판매자정보입력</span></span>
				</div>
			</div>

		</div>
		<div class="seller-container">
			<h2 class="main-title">판매자님의 추가 정보를 입력해주세요</h2>

			<!-- ✅ 계좌 등록 -->
			<section class="section-box">
				<div class="section-title">
					<span class="check">✔</span> 계좌 등록하기
				</div>
				<p class="section-desc">판매수익금으로 입금 받을 계좌를 등록해주세요</p>

				<label for="account-owner">이름</label> <input type="text"
					id="account-owner" class="input-box" placeholder="내용을 입력하세요" /> <label
					for="bank">은행을 선택해 주세요.</label> <select id="bank" class="input-box">
					<option>선택해주세요.</option>
					<option>국민은행</option>
					<option>신한은행</option>
					<option>하나은행</option>
					<!-- 필요한 은행 추가 -->
				</select> <label for="account-number">계좌번호를 입력해 주세요.</label>
				<!-- 계좌번호 입력 안내 박스 -->
				<div class="account-warning-box">
					<div class="account-warning-title">
						<span class="check">✔</span> <strong>간편결제로 연결할 수 없는 계좌</strong>
					</div>
					<ul class="account-warning-list">
						<li>본인 명의가 아닌 계좌</li>
						<li>가상계좌/적금/펀드/정기예금 등의 계좌</li>
						<li>휴대폰 번호 등으로 만든 평생 계좌번호</li>
						<li>계좌에 문제가 있는 경우 (예: 지급정지 또는 해약된 경우)</li>
					</ul>
				</div>


				<div class="account-input">
					<input type="text" id="account-number" class="input-box2"
						placeholder="-없이 계좌번호 입력" />
					<button class="account-button">계좌 등록하기</button>
				</div>
			</section>

			<!-- ✅ 나의 이력 등록 -->
			<section class="section-box">
				<div class="section-title">
					<span class="check">✔</span> 나의 이력 등록하기
				</div>
				<p class="section-desc">판매자님의 작품 사진을 등록해주세요. 최대 5장 등록하실 수 있습니다.</p>

				<div class="career-wrapper">
					<c:forEach begin="1" end="5" var="i">
						<div class="career-box">
							<div class="upload-placeholder">+</div>
							<textarea class="career-text" placeholder="${i}번째 이력 설명"></textarea>
							<div class="char-count">0/150</div>
						</div>
					</c:forEach>
				</div>
			</section>

			<div class="button-wrapper">
				<button type="button" class="btn-outline" onclick="history.back()">돌아가기</button>
				<button type="submit" class="btn-primary">등록하기</button>
			</div>
		</div>
	</div>


</body>
</html>