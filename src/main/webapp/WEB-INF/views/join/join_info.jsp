<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원가입_회원정보입력</title>

  <!-- Pretendard 폰트 (CDN 연결) -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/variable/pretendardvariable.css" />

  <!-- CSS 적용 -->
  <link rel="stylesheet" type="text/css" href="${cpath}/resources/css/join/info_style.css">
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
        <img class="header-illustration" src="${cpath}/resources/images/illustration.png" />
      </div>
    </div>

    <!-- 메인 컨텐츠 -->
    <div class="main-wrapper">
      <!-- 가입 단계 -->
      <div class="step-indicator">
       <div class="step">01 <br /> 약관동의</div>
        <img class="arrow" src="${cpath}/resources/images/arrow-right.svg" />
        <div class="step current">
          <span><span class="step-num">02<br /></span><span class="step-label">회원정보입력</span></span>
        </div>
        <img class="arrow" src="${cpath}/resources/images/arrow-right.svg" />
        <div class="step">03 <br /> 완료</div>
        <img class="arrow" src="${cpath}/resources/images/arrow-right.svg" />
        <div class="step">01 <br /> 판매자정보입력</div>
      </div>

    <!-- 회원가입 입력 폼 -->
    <div class="register-wrapper">
      <h2 class="title">회원님의 정보를 입력해주세요</h2>
      <p class="subtitle">소셜정보로 원클릭 가입하기</p>

      <div class="social-login">
        <img src="${cpath}/resources/images/naver.png" alt="네이버" class="social-icon"   />
        <img src="${cpath}/resources/images/kakao.png" alt="카카오" class="social-icon"  />
      </div>
      
       
      
      

      <form>
        <div class="form-group">
          <label>* 아이디(이메일)</label>
          <div class="input-with-button">
            <input type="email" placeholder="내용을 입력하세요" required>
            <button type="button">이메일인증</button>
          </div>
        </div>

        <div class="form-group">
          <label>* 비밀번호</label>
          <input type="password" placeholder="내용을 입력하세요" required>
        </div>

        <div class="form-group">
          <label>* 비밀번호 확인</label>
          <input type="password" placeholder="내용을 입력하세요" required>
        </div>

        <div class="form-group">
          <label>사용자 이름</label>
          <input type="text" placeholder="내용을 입력하세요">
        </div>

        <div class="form-group">
          <label>휴대전화번호</label>
          <input type="text" placeholder="내용을 입력하세요">
        </div>

        <div class="form-group">
          <label>주민등록번호</label>
          <div class="rrn-box">
            <input type="text" maxlength="6" placeholder="앞 6자리">
            <span>-</span>
            <input type="password" maxlength="7" placeholder="뒤 7자리">
          </div>
        </div>

        <div class="form-group">
          <label>주소 입력</label>
          <div class="input-with-button">
            <input type="text" placeholder="검색 버튼을 눌러주세요" readonly>
            <button type="button">검색</button>
          </div>
        </div>

        <div class="form-group">
          <label>* 회원유형선택</label>
          <p class="type-desc">판매자 선택 시 판매자 가입단계로 이동됩니다.<br>판매자 선택 시에도 구매가 가능하며, 추후 판매자 가입도 가능합니다.</p>
          <div class="user-types">
            <button type="button" class="type-button">구매자</button>
            <button type="button" class="type-button">판매자</button>
          </div>
        </div>

        <div class="form-buttons">
          <button type="reset" class="cancel">취소</button>
          <button type="submit" class="submit">다음</button>
        </div>
      </form>
    </div>

  </div>
</body>
</html>
