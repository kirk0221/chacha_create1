<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>웹사이트 레이아웃</title>
  <link rel="stylesheet" href="${cpath}/resources/css/main_mypage_correction_style.css">
</head>
<body>
  <div class="wrapper">

     <!-- ✅ Include Header & Nav -->
<jsp:include page="/common/header.jsp" />
<jsp:include page="/common/main_nav.jsp" />

    <!-- 메인 콘텐츠 영역 -->
    <main class="main-area">
      <!-- 왼쪽 사이드바 -->
      <aside class="sidebar">
        <ul>
          <li><a href="#">대시보드</a></li>
          <li><a href="#">내 정보</a></li>
          <li><a href="#">판매 관리</a></li>
          <li><a href="#">정산 내역</a></li>
        </ul>
      </aside>

      <!-- 오른쪽 콘텐츠 영역 -->
      <section class="page-content">
        <h2>내 정보 수정</h2>

        <form class="info-form">
          <div class="form-group">
            <label>이름</label>
            <input type="text" value="홍길동" disabled />
          </div>

          <div class="form-group">
            <label>이메일</label>
            <input type="email" value="example@naver.com" />
          </div>

          <div class="form-group">
            <label>비밀번호</label>
            <input type="password" placeholder="변경할 비밀번호 입력" />
          </div>

          <div class="form-group">
            <label>비밀번호 확인</label>
            <input type="password" placeholder="비밀번호 확인" />
          </div>

          <div class="form-group">
            <label>연락처</label>
            <input type="text" value="010-1234-5678" />
          </div>

          <div class="form-group">
            <label>주소</label>
            <div class="address-group">
              <input type="text" placeholder="우편번호" style="width: 120px;" />
              <button type="button" class="search-btn">검색</button>
            </div>
            <input type="text" placeholder="주소" />
            <input type="text" placeholder="상세주소" />
          </div>

          <div class="form-actions">
            <button type="submit" class="save-btn">저장</button>
            <button type="reset" class="cancel-btn">취소</button>
          </div>
        </form>

        <!-- ✅ 결제수단 영역: page-content 내부에 위치 -->
        <div class="payment-section">
          <button type="button" class="toggle-payment-form">결제수단 등록 / 수정</button>

          <form class="payment-form" style="display: none;">
            <div class="form-group">
              <label>카드 번호</label>
              <input type="text" placeholder="0000 - 0000 - 0000 - 0000" />
            </div>

            <div class="form-group">
              <label>유효기간</label>
              <div class="card-expiry">
                <input type="text" placeholder="MM/YY" />
              </div>
            </div>

            <div class="form-group">
              <label>카드사</label>
              <select>
                <option>카드를 선택하세요</option>
                <option>신한카드</option>
                <option>삼성카드</option>
                <option>국민카드</option>
                <option>현대카드</option>
                <option>우리카드</option>
              </select>
            </div>

            <div class="form-actions">
              <button type="submit" class="save-btn">등록</button>
              <button type="button" class="cancel-btn cancel-payment">취소</button>
            </div>
          </form>

          <!-- 등록된 결제수단 -->
          <div class="registered-payment">
            <h3>등록된 결제수단</h3>
            <div class="card-item">
              <span class="card-info">신한카드 **** **** **** 1234</span>
              <span class="card-date">등록일: 2022년 06월 16일</span>
              <div class="card-actions">
                <button class="edit-btn">수정</button>
                <button class="delete-btn">삭제</button>
              </div>
            </div>
          </div>
        </div>

      </section>
    </main>

    <!-- 푸터 -->
    <footer class="site-footer">
      <div class="footer-inner">
        <p>© 2025 뜨락상회. All rights reserved.</p>
      </div>
    </footer>

  </div>

  <!-- 스크립트 -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    $(function () {
      $(".toggle-payment-form").click(function () {
        $(".payment-form").slideToggle();
      });

      $(".cancel-payment").click(function () {
        $(".payment-form").slideUp();
      });
    });
  </script>
</body>
</html>
