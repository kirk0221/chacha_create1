<!-- :흰색_확인_표시: JSP: 회원가입 완료 표시 추가 (기존 JSP 구조 유지하면서 "완료" 표시 추가)-->
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>스토어 개설 신청</title>
<link rel="stylesheet" type="text/css"
	href="${cpath}/resources/css/main/sellerJoin.css">
<script src="https://code.iconify.design/iconify-icon/1.0.8/iconify-icon.min.js"></script>
</head>
<body>
	<div class="container">
		<!-- 상단 배너 -->
		<div class="header-banner">
			<div class="header-content">
				<div class="logo-title-wrapper">
					<img class="logo" src="${cpath}/resources/images/logo.png" />
					<div class="page-title">스토어 개설 신청</div>
				</div>
				<img class="header-illustration"
					src="${cpath}/resources/images/illustration.png" />
			</div>
		</div>
	
		<div class="seller-container">
			<h2 class="main-title">스토어 개설 신청하기</h2>
			
			<div class="form-group">
				<div class="field-label-wrapper">
					<div class="div17">스토어 이름</div>
					<div class="required-mark">*</div>
				</div>
				<div class="frame-754">
					<input type="text" class="input-field" placeholder="스토어 이름을 입력하세요"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="field-label-wrapper">
					<div class="div17">스토어 대표사진(로고)</div>
					<div class="required-mark">*</div>
				</div>
				<button class="frame-817-btn" type="button" aria-label="추가 버튼">
				  <iconify-icon icon="mdi:plus" class="icon-plus"></iconify-icon>
				</button>
			</div>
			
			<div class="form-group">
				<div class="field-label-wrapper">
					<div class="div17">스토어 URL</div>
					<div class="required-mark">*</div>
				</div>
				<div class="frame-754">
					<input type="text" class="input-field" placeholder="스토어 URL을 입력하세요"/>
				</div>
			</div>
			
			<div class="form-group">
				<div class="field-label-wrapper">
					<div class="div17">스토어 설명</div>
					<div class="required-mark">*</div>
				</div>
				<textarea class="box" placeholder="내용을 입력하세요"></textarea>
				  <div class="counter-low">
				    <div class="_12">1</div>
				    <div class="_100">/3000</div>
				  </div>
			</div>
			
			<div class="form-group consent-section">
			  <div class="consent-title-wrapper">
			    <span class="consent-title">정보를 수집하고 이용하는데 동의합니다.</span>
			      <iconify-icon icon="mdi:open-in-new" style="font-size: 16px;"></iconify-icon>
			    <span class="required-mark">*</span>
			  </div>
			  <div class="consent-subtext">2년 이내 정보는 파기됩니다.</div>
			  <label class="checkbox-wrapper">
			    <input type="checkbox" class="checkbox-input" />
			    <span class="checkbox-label">동의합니다.</span>
			  </label>
			</div>
			
			<div class="frame-752">
		      <div class="component-3">
		        <button class="close-btn">신청하기</button>
		      </div>
		    </div>
		</div>
	</div>
	
</body>
</html>