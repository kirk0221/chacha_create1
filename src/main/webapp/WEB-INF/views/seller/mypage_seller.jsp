<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>뜨락상회 판매자 메인페이지</title>
  <link rel="stylesheet" type="text/css" href="resources/css/authmain.css">
  <link rel="stylesheet" type="text/css" href="resources/css/mypage_seller_style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://code.iconify.design/iconify-icon/1.0.8/iconify-icon.min.js"></script>
</head>
<body>

<div class="wrapper">
  <header>
    <div class="header-inner">
      <div class="login-bar">
        <span>수제대추고님 반갑습니다.</span>
        <button class="logout-btn">로그아웃</button>
      </div>
    </div>
  </header>

  <div class="main-area">
    <div class="content-wrapper">
      <nav class="sidebar">
		  <div class="profile-section" onclick="#" role="button" tabindex="0" aria-label="스토어관리 페이지로 이동">
		    <img src="_11.png" class="profile-img" />
		    <div class="store-name">수제대추고</div>
		  </div>
		  <ul class="menu-list">
		    <li><a href="#"><span class="menu-text">상품등록</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">판매상품관리</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">주문/발송확인(취소/환불)</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">환불관리</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">정산관리</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">문의메시지</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">리뷰관리</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">스토어관리</span><span class="arrow">></span></a></li>
		  </ul>
		  <div class="sidebar-footer">
		    <button class="btn-go-buyer" onclick="#">구매자페이지 이동</button>
		  </div>
		</nav>

      <main class="content">
        <div class="content-inner">

          <!-- 주문/배송 -->
          <a href="#" style="text-decoration: none; color: inherit;">
            <div class="member-box fixed-box">
              <div class="member-header">
                <div class="title-with-info">
                  <h2>주문 · 배송</h2>
                  <iconify-icon icon="mdi:information-outline" style="font-size: 18px; margin-left: 8px;"></iconify-icon>
                  <div class="_1">최근 1주일 기준</div>
                </div>
              </div>
              <div class="member-body">
                <div class="frame-1034">
                  <a href="#" class="frame-1035 link-box">
                    <div class="ellipse-1">
                      <iconify-icon icon="mdi:file-document-outline" class="icon-inner"></iconify-icon>
                    </div>
                    <div class="frame-1039">
                      <div class="div11">신규주문</div>
                      <div class="_1000">1000건</div>
                    </div>
                  </a>
                  <a href="#" class="frame-1035 link-box">
                    <div class="ellipse-1">
                      <iconify-icon icon="mdi:clock-outline" class="icon-inner"></iconify-icon>
                    </div>
                    <div class="frame-1039">
                      <div class="div11">발송전</div>
                      <div class="_1000">1000건</div>
                    </div>
                  </a>
                  <a href="#" class="frame-1035 link-box">
                    <div class="ellipse-1">
                      <iconify-icon icon="mdi:truck-check-outline" class="icon-inner"></iconify-icon>
                    </div>
                    <div class="frame-1039">
                      <div class="div11">배송완료</div>
                      <div class="_1000">1000건</div>
                    </div>
                  </a>
                  <a href="#" class="frame-1035 link-box">
                    <div class="ellipse-1">
                      <iconify-icon icon="mdi:close-circle-outline" class="icon-inner"></iconify-icon>
                    </div>
                    <div class="frame-1039">
                      <div class="div11">취소요청</div>
                      <div class="_1000">1000건</div>
                    </div>
                  </a>
                  <a href="#" class="frame-1035 link-box">
                    <div class="ellipse-1">
                      <iconify-icon icon="mdi:refresh-circle" class="icon-inner"></iconify-icon>
                    </div>
                    <div class="frame-1039">
                      <div class="div11">환불요청</div>
                      <div class="_1000">1000건</div>
                    </div>
                  </a>
                </div>
              </div>
            </div>
          </a>

          <!-- 정산관리 -->
          <a href="#" style="text-decoration: none; color: inherit;">
            <div class="member-box scroll-box">
              <div class="member-header">
                <div class="title-with-info">
                  <h2>정산관리</h2>
                  <iconify-icon icon="mdi:information-outline" style="font-size: 18px; margin-left: 8px;"></iconify-icon>
                  <div class="_1">금일 일별 매출그래프</div>
                </div>
              </div>
              <div class="member-body">
                <div class="chart-placeholder">
                  &lt;매출 차트 삽입&gt;
                </div>
              </div>
            </div>
          </a>

          <!-- 신규 리뷰관리 -->
          <a href="#" style="text-decoration: none; color: inherit;">
            <div class="member-box scroll-box">
              <div class="member-header">
                <div class="title-with-info">
                  <h2>신규 리뷰관리</h2>
                </div>
              </div>
              <div class="member-body">
                <div class="review-content-row">
                  <a href="#" class="frame-1035 link-box fixed-width">
                    <div class="ellipse-1">
                      <iconify-icon icon="mdi:pencil-box-outline" class="icon-inner"></iconify-icon>
                    </div>
                    <div class="frame-1039">
                      <div class="div11">신규리뷰</div>
                      <div class="_1000">99건</div>
                    </div>
                  </a>
                  <div class="reviewgraph-placeholder right-side">
                    &lt;리뷰 표 삽입&gt;
                  </div>
                </div>
              </div>
            </div>
          </a>

        </div>
      </main>
    </div>
  </div>

  <footer>&copy; 2025 뜨락상회</footer>
</div>

</body>
</html>
