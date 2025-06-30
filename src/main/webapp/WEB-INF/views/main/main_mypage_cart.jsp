<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>장바구니</title>
  <link rel="stylesheet" href="resources/css/main_mypage_cart_style.css">
</head>
<body>
  <div class="wrapper">

    <!-- 헤더 -->
    <header>
      <div class="header-inner">
        <div class="login-bar">
          <span>관리자님 반갑습니다.</span>
          <button class="logout-btn">로그아웃</button>
        </div>
      </div>
    </header>

    <!-- 내비게이션 -->
    <nav class="site-nav">
      <div class="nav-inner">
        <div class="nav-logo">뜨락상회</div>
        <ul class="nav-menu">
          <li><a href="#">홈</a></li>
          <li><a href="#">스토어</a></li>
          <li><a href="#">이벤트</a></li>
          <li><a href="#">고객센터</a></li>
        </ul>
      </div>
    </nav>

    <!-- 메인 콘텐츠 영역 -->
    <main class="main-area">
      <aside class="sidebar">
        <ul>
          <li><a href="#">대시보드</a></li>
          <li><a href="#">내 정보</a></li>
          <li><a href="#">판매 관리</a></li>
          <li><a href="#">정산 내역</a></li>
        </ul>
      </aside>

      <section class="cart-content">
        <h2>장바구니</h2>

        <!-- ✅ 전체 선택 체크박스 -->
        <div class="cart-select-all">
          <label>
            <input type="checkbox" class="select-all" /> 전체 선택
          </label>
        </div>

        <div class="cart-wrapper">

          <!-- 장바구니 상품 리스트 -->
          <div class="cart-items">
            <div class="cart-title">현재 스토어 장바구니</div>

            <!-- 상품 1 -->
            <div class="cart-item">
              <input type="checkbox" />
              <img src="resources/images/product_sample.png" alt="상품 이미지" class="item-img" />

              <div class="item-info">
                <div class="item-store">OOO 스토어</div>
                <div class="item-name">플라밍고 인형</div>
                <div class="item-desc">귀여운 플라밍고 인형입니다.</div>
                <div class="item-price">10,000원</div>
              </div>

              <div class="item-qty">
                <button>-</button>
                <input type="text" value="1" />
                <button>+</button>
              </div>
            </div>

            <!-- 상품 2 -->
            <div class="cart-item">
              <input type="checkbox" />
              <img src="resources/images/product_sample.png" alt="상품 이미지" class="item-img" />

              <div class="item-info">
                <div class="item-store">OOO 스토어</div>
                <div class="item-name">핸드메이드 컵</div>
                <div class="item-desc">정성스럽게 만든 도자기 컵</div>
                <div class="item-price">5,000원</div>
              </div>

              <div class="item-qty">
                <button>-</button>
                <input type="text" value="2" />
                <button>+</button>
              </div>
            </div>

            <!-- 상품 3 -->
            <div class="cart-item">
              <input type="checkbox" />
              <img src="resources/images/product_sample.png" alt="상품 이미지" class="item-img" />

              <div class="item-info">
                <div class="item-store">OOO 스토어</div>
                <div class="item-name">패브릭 포스터</div>
                <div class="item-desc">감성적인 무드의 패브릭 포스터</div>
                <div class="item-price">15,000원</div>
              </div>

              <div class="item-qty">
                <button>-</button>
                <input type="text" value="1" />
                <button>+</button>
              </div>
            </div>

          </div>

          <!-- 주문 요약 -->
          <div class="cart-summary">
            <h3>주문 예상 금액</h3>
            <ul class="summary-list">
              <li><span>상품 금액</span><span>0 원</span></li>
              <li><span>배송비</span><span>0 원</span></li>
              <li class="summary-total"><span>총 합계</span><span>0 원</span></li>
            </ul>
            <button class="btn-order">결제하기</button>
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
      function updateSummary() {
        let total = 0;

        $('.cart-item').each(function () {
          const checkbox = $(this).find('input[type="checkbox"]');
          if (checkbox.is(':checked')) {
            const unitPrice = parseInt($(this).find('.item-price').text().replace(/[^\d]/g, ''));
            const quantity = parseInt($(this).find('.item-qty input').val());
            total += unitPrice * quantity;
          }
        });

        const shipping = total > 0 ? 2500 : 0;
        const totalAmount = total + shipping;

        $('.summary-list').html(`
          <li><span>상품 금액</span><span>${total.toLocaleString()} 원</span></li>
          <li><span>배송비</span><span>${shipping.toLocaleString()} 원</span></li>
          <li class="summary-total"><span>총 합계</span><span>${totalAmount.toLocaleString()} 원</span></li>
        `);
      }

      // 수량 증가
      $('.item-qty button:contains("+")').on('click', function () {
        const $qty = $(this).siblings('input');
        $qty.val(parseInt($qty.val()) + 1);
        updateSummary();
      });

      // 수량 감소
      $('.item-qty button:contains("-")').on('click', function () {
        const $qty = $(this).siblings('input');
        const newVal = Math.max(1, parseInt($qty.val()) - 1);
        $qty.val(newVal);
        updateSummary();
      });

      // 직접 수량 입력
      $('.item-qty input').on('input', function () {
        const val = parseInt($(this).val());
        if (isNaN(val) || val < 1) {
          $(this).val(1);
        }
        updateSummary();
      });

      // 개별 체크 시 전체 선택 체크박스 상태 동기화
      $('.cart-item input[type="checkbox"]').on('change', function () {
        const total = $('.cart-item input[type="checkbox"]').length;
        const checked = $('.cart-item input[type="checkbox"]:checked').length;
        $('.select-all').prop('checked', total === checked);
        updateSummary();
      });

      // 전체 선택 체크박스
      $('.select-all').on('change', function () {
        const isChecked = $(this).is(':checked');
        $('.cart-item input[type="checkbox"]').prop('checked', isChecked);
        updateSummary();
      });

      // 초기 계산
      updateSummary();
    });
  </script>
</body>
</html>
