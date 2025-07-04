<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>마이페이지</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <link rel="stylesheet" href="${cpath}/resources/css/main/mypage/mainMyPage.css">
  <script>const cpath = '${cpath}';</script>
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="${cpath}/resources/js/main/mypage/mainMyPage.js"></script>
</head>
<body>
  <div class="wrapper">

     <!-- ✅ Include Header & Nav -->
<jsp:include page="/common/header.jsp" />
<jsp:include page="/common/main_nav.jsp" />

    <!-- 메인 콘텐츠 영역 -->
    <main class="main-area">
      <!-- 왼쪽 사이드바 -->
     <jsp:include page="/common/main_mypage_sidenav.jsp" />

      <!-- 오른쪽 콘텐츠 영역 -->
      <section class="page-content">
        <h2>내 정보 수정</h2>

        <form class="info-form">
          <div class="form-group">
            <label>이름</label>
            <input type="text" class="name" disabled />
          </div>

          <div class="form-group">
            <label>이메일</label>
            <input type="email" class="email" disabled/>
          </div>

          <div class="form-group">
            <label>비밀번호</label>
            <input type="password" class="password" placeholder="변경할 비밀번호 입력" />
          </div>

          <div class="form-group">
            <label>비밀번호 확인</label>
            <input type="password" class="password-ok" placeholder="비밀번호 확인" />
          </div>

          <div class="form-group">
            <label>연락처</label>
            <input type="text" class="phone" disabled/>
          </div>

          <div class="form-group">
            <label>주소</label>
            <div class="address-group">
              <input type="text" class="post-num" placeholder="우편번호" style="width: 120px;" disabled/>
              <button type="button" class="search-btn">검색</button>
            </div>
            <input type="hidden" class="address-road" name="address-road" />
			<input type="hidden" class="address-extra" name="address-extra" />
            <input type="text" class="address" placeholder="주소" />
            <input type="text" class="address-detail" placeholder="상세주소" />
          </div>

          <div class="form-actions">
            <button type="submit" class="save-btn">저장</button>
            <button type="reset" class="cancel-btn">취소</button>
          </div>
        </form>

        <!-- ✅ 결제수단 영역: page-content 내부에 위치 -->
<div class="payment-section">
  <button type="button" class="toggle-payment-form">판매자 정보 수정</button>

  <form class="payment-form" style="display: none;">

    <!-- ✅ 계좌 등록 -->
    <section class="section-box">
      <div class="section-title">
        <span class="check">✔</span> 계좌 등록하기
      </div>
      <p class="section-desc">판매수익금으로 입금 받을 계좌를 등록해주세요</p>

      <label for="account-owner">이름</label>
      <input type="text" id="account-owner" class="input-box" placeholder="로그인 사용자 이름"
        readonly value="${sessionScope.loginMember.memberName}" />

      <label for="bank">은행을 선택해 주세요.</label>
      <select id="bankselect" class="input-box">
        <option value="">은행선택</option>
        <option value="004">국민은행</option>
        <option value="020">우리은행</option>
        <option value="088">신한은행</option>
        <option value="003">기업은행</option>
        <option value="023">SC제일은행</option>
        <option value="011">농협은행</option>
        <option value="005">외환은행</option>
        <option value="090">카카오뱅크</option>
        <option value="032">부산은행</option>
        <option value="071">우체국</option>
        <option value="031">대구은행</option>
        <option value="037">전북은행</option>
        <option value="035">제주은행</option>
        <option value="007">수협은행</option>
        <option value="027">씨티은행</option>
        <option value="039">경남은행</option>
      </select>

      <label for="account-number">계좌번호를 입력해 주세요.</label>

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
        <input type="text" id="accountnum" class="input-box2" placeholder="-없이 계좌번호 입력" />
        <input type="text" id="accountname" class="input-box2" placeholder="예금주명" readonly />
        <button type="button" class="account-button" id="accountSubmit">계좌 수정하기</button>
      </div>
    </section>

    <!-- ✅ 나의 이력 등록 -->
    <section class="section-box">
      <div class="section-title">
        <span class="check">✔</span> 나의 이력 등록하기
      </div>
      <p class="section-desc">판매자님의 작품 사진을 등록해주세요.</p>

      <div class="career-wrapper">
        <div class="career-box">
          <div class="upload-placeholder" id="previewBox">+</div>
			<input type="file" id="fileInput" accept="image/*" style="display: none;" />
          <textarea class="career-text" placeholder="이력 설명"></textarea>
          <div class="char-count">0/150</div>
        </div>
      </div>
    </section>

    <!-- ✅ 공통 하단 버튼 -->
    <div class="form-actions">
      <button type="submit" class="save-btn">저장</button>
      <button type="button" class="cancel-btn cancel-payment">취소</button>
    </div>
  </form>
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
    
/* ----------------폼 스크립트 */
	
	$(document).ready(function () {
		
		//-----------------텍스트 길이 체크--------------		
		$('.career-text').on('input', function() {
	        const maxLength = 150;
	        const currentLength = $(this).val().length;
	        const charCountText = currentLength + '/' + maxLength;
	        
	        // 같은 부모요소 내의 .char-count에 글자수 업데이트
	        $(this).siblings('.char-count').text(charCountText);

	        // 150자 초과시 자르기 (선택사항)
	        if (currentLength > maxLength) {
	            $(this).val($(this).val().substring(0, maxLength));
	            $(this).siblings('.char-count').text(maxLength + '/' + maxLength);
	        }
	    });

		//-----------------사진 파일 실시간 반영(파일명 기준)--------------		
		
		  $('.upload-placeholder').on('click', function () {
		    $('#fileInput').click();
		  });
		  $('#fileInput').on('change', function (e) {
			  const file = e.target.files[0];
			  if (!file) return;

			  // 허용할 확장자 배열
			  const allowedExtensions = ['jpg', 'jpeg', 'png', 'gif'];

			  // 파일명에서 확장자 추출 (소문자 변환)
			  const fileName = file.name.toLowerCase();
			  const extension = fileName.split('.').pop();

			  if (!allowedExtensions.includes(extension)) {
			    alert('jpg, jpeg, png, gif 형식의 이미지 파일만 선택할 수 있습니다.');
			    $(this).val('');  // 선택 초기화
			    return;
			  }

			  // 이미지 파일일 때 처리 (기존 미리보기 등)
			  const reader = new FileReader();
			  reader.onload = function (event) {
			    $('.upload-placeholder').html(`<img src="${cpath}/resources/productImages/\${file.name}" style="max-width: 100%; max-height: 100%; object-fit: contain; display: block;">`);
			  };
			  reader.readAsDataURL(file);
			});
	});
	const checkObj = {
			"accountname": false
		}
	
		$(function() {
			
			function checkmyinfo() {
				const bank_code = $('#bankselect').val();
				const bank_num = $('#accountnum').val();

				if (!bank_code || !bank_num) {
					alert('은행과 계좌번호를 모두 입력해주세요.');
					return;
				}

				$.ajax({
					url : '${cpath}/api/checkAccount',
					method : 'GET',
					data : {
						bank_code : bank_code,
						bank_num : bank_num
					},
					success : function(res) {
						if (res.bankHolderInfo) {
		                    $('#accountname').val(res.bankHolderInfo);// 예금주명 입력

		                    // account-owner와 비교
		                    const accountOwner = $('#account-owner').val();
		                    if (accountOwner === res.bankHolderInfo) {
		                        checkObj.accountname = true;
								// 은행 선택 비활성화
						        $('#bankselect').prop('disabled', true);
						        // 계좌번호 입력 비활성화
						        $('#accountnum').prop('disabled', true);
		                    } else {
		                        checkObj.accountname = false;
		                        alert('예금주명이 로그인 사용자와 다릅니다.');
		                    }
						} else {
							alert('예금주 정보를 찾을 수 없습니다.');
						}
					},
					error : function(xhr, status, error) {
						console.error('요청 실패:', error);
						alert('예금주 조회 중 오류가 발생했습니다.');
					}
				});
			}

			// 버튼 클릭 시 실행
			$('#accountSubmit').on('click', checkmyinfo);
		});
	
	$(function() {
	    $('#sellerinfo').on('submit', function(e) {
	        e.preventDefault(); // 폼 제출 기본 동작 막기
	        if (!checkObj.accountname) {
	            alert('예금주명이 로그인 사용자 이름과 일치해야 제출할 수 있습니다.');
	        } else {
		        // 폼에서 필요한 데이터 수집
		        // (예: account, accountBank, profileInfo, personalCheck 등)
		        // 여기서는 계좌 정보와 프로필 정보 예시로 작성
	
		        const sellerData = {
		            account: $('#accountnum').val(),
		            accountBank: $('#bankselect option:selected').text(),
		            profileInfo: $('.profile-info-textarea').val() || ''  // 예시, 프로필 텍스트영역 필요 시
		        };
	
		        // 유효성 체크 (예: 계좌번호, 은행명 체크)
		        if (!sellerData.account || !sellerData.accountBank) {
		            alert('계좌번호와 은행명을 입력해 주세요.');
		            return;
		        }
	
		        $.ajax({
		            url: '${cpath}/api/auth/join/seller',
		            method: 'POST',
		            contentType: 'application/json',
		            data: JSON.stringify(sellerData),
		            success: function(res) {
		                alert('판매자 정보가 성공적으로 등록되었습니다.');
		                console.log(res);
		                window.location.href = '${cpath}/auth/join/complete';
		            },
		            error: function(xhr, status, error) {
		                alert('판매자 정보 등록에 실패했습니다: ' + error);
		            }
		        });
	        }
       });
	});

  </script>
</body>
</html>
