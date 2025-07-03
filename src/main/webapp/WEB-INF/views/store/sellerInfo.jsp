<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>판매자 정보</title>
<link rel="stylesheet"
	href="${cpath}/resources/css/store/sellerInfo.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="seller-container">
		<!-- 프로필 -->
		<div class="profile-section">
			<img id="logoImg" src="" alt="스토어 이미지" class="profile-img">
			<h2 class="profile-name" id="storeName">스토어 이름</h2>
		</div>

		<!-- 판매자 기본 정보 -->
		<div class="info-card">
			<h3 class="section-title">판매자 기본 정보</h3>
			<div class="info-row">
				<span class="label">이름</span><span class="value" id="sellerName"></span>
			</div>
			<div class="info-row">
				<span class="label">연락처</span><span class="value" id="sellerPhone"></span>
			</div>
			<div class="info-row">
				<span class="label">이메일</span><span class="value" id="sellerEmail"></span>
			</div>
		</div>

		<!-- 스토어 소개 -->
		<div class="info-card">
			<h3 class="section-title">스토어 소개</h3>
			<p class="desc-box" id="storeDetail"></p>
		</div>

		<!-- 이력 -->
		<div class="info-card">
			<h3 class="section-title">나의 이력</h3>
			<ul class="history-list" id="sellerProfile"></ul>
		</div>
	</div>

	<script>
		$(document).ready(
				function() {
					const storeUrl = '${storeUrl}'; // URL 경로에서 storeUrl 전달됨
					$.ajax({
						url : '/create/api/' + storeUrl + '/info',
						method : 'GET',
						success : function(res) {
							
							const store = res.data.storeInfoList[0];
							const seller = res.data.sellerInfoList[0];
							
							$('#storeName').text(store.storeName);
							$('#storeDetail').text(store.storeDetail);
							$('#sellerName').text(seller.sellerName);
							$('#sellerPhone').text(seller.sellerPhone);
							$('#sellerEmail').text(seller.sellerEmail);
							$('#sellerProfile').append(
									'<li>' + seller.sellerProfile + '</li>');
							$('#logoImg').attr('src', '${cpath}/resources/images/' + store.logoImg);
						},
						error : function(err) {
							console.error("판매자 정보 불러오기 실패:", err);
						}
					});
				});
	</script>
</body>
</html>
