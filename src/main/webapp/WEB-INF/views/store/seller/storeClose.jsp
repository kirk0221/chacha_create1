<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뜨락상회 스토어폐업</title>
<%@ include file="/common/header.jsp" %>
  <link rel="stylesheet" href="${cpath}/resources/css/store/seller/authmain.css">
  <link rel="stylesheet" href="${cpath}/resources/css/store/seller/storeClose.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.iconify.design/iconify-icon/1.0.8/iconify-icon.min.js"></script>
</head>
<body>
<div class="wrapper">
  <div class="main-area">
    <div class="content-wrapper">
     <%@ include file="/common/store_seller_sidenav.jsp" %>

      <main class="content">
        <div class="content-inner">
		  <h2>스토어 폐업 신청</h2>
		
		  <div class="frame-1171">
		    <div class="icon-system-warning">
			  <iconify-icon icon="ic:round-warning" style="color: #FF4D4F; font-size: 80px;"></iconify-icon>
			</div>
		    <div class="div16">정말로 폐업하시겠습니까?</div>
		    <div class="div17">
		      <div class="frame-758">
		        <div class="frame-757">
		          <div class="frame-754">
		            <input type="text" class="input-field" placeholder="이메일" />
		          </div>
		          <div class="frame-754">
		            <input type="password" class="input-field" placeholder="비밀번호" />
		          </div>
		        </div>
		      </div>
		    </div>
		    <div class="frame-752">
		      <div class="component-3">
		        <button class="close-btn">폐업하기</button>
		      </div>
		    </div>
		  </div>
		</div>
      </main>
    </div>
  </div>
  <footer>&copy; 2025 뜨락상회</footer>
</div>
</body>
</html>