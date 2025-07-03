<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>개인 판매 물품 등록</title>
  <link rel="stylesheet" href="${cpath}/resources/css/main/personal/saleRegistration.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <!-- ✅ Include Header & Nav -->
<jsp:include page="/common/header.jsp" />
<jsp:include page="/common/main_nav.jsp" />

<main class="register-container">
<jsp:include page="/common/main_personal_subnav.jsp" />

  <div class="explanation-box">
    <p>여기에는 개인판매 물품 등록하고 어쩌고 저쩌고 하는 방법들을 설명해놓는 칸입니다.<br>아래에는 접거나 사진을 넣고 만들 예정입니다.</p>
    <button class="open-store-btn">스토어 개설 신청</button>
  </div>

  <!-- 슬라이드 버튼 -->
  <button class="slide-arrow left">&lt;</button>

  <!-- 슬라이드 전체 -->
  <div class="slider-wrapper">
    <div class="slide-container">

      <!-- 한 세트 -->
      <div class="slide-full">
        <div class="slide-card">
          <div class="image-upload-wrapper">
				<!-- 이미지 1 -->
				<div class="img-placeholder" id="upload-placeholder1"></div>
				<input type="file" id="fileInput1" accept=".jpg,.jpeg,.png,.gif" style="display: none;">
				
				<!-- 이미지 2 -->
				<div class="img-placeholder" id="upload-placeholder2"></div>
				<input type="file" id="fileInput2" accept=".jpg,.jpeg,.png,.gif" style="display: none;">
				
				<!-- 이미지 3 -->
				<div class="img-placeholder" id="upload-placeholder3"></div>
				<input type="file" id="fileInput3" accept=".jpg,.jpeg,.png,.gif" style="display: none;">
			</div>
          <div class="product-info">
            <h3>이곳에 상품명을 입력하세요</h3><input type="text" id="productName" placeholder="상품명">
            <p><strong>10,000</strong> 원</p><input type="number" id="price" placeholder="가격">
            <p>재고 <strong>NNN</strong> 개</p><input type="number" id="stock" placeholder="재고">
            <div class="category">
			  <label>대분류</label>
			  <select id="typeCategory" name="typeCategory" class="category-select">
			    <option value="">-- 선택 --</option>
				  <option value="METAL">금속공예</option>
				  <option value="WOOD">목공예</option>
				  <option value="CERAMIC">도자기공예</option>
				  <option value="GLASS">유리공예</option>
				  <option value="LEATHER">가죽공예</option>
				  <option value="RESIN">레진공예</option>
				  <option value="PLANT">식물공예</option>
				  <option value="KNITTING">뜨개질공예</option>
				  <option value="SEWING">양재공예</option>
				  <option value="TYPE_ETC">기타</option>
			  </select>
			
			<label>중분류</label>
			<select id="uCategory" name="uCategory" class="category-select">
			  <option value="">-- 선택 --</option>
			  <option value="FASHION">패션잡화</option>
			  <option value="INTERIOR">인테리어 소품</option>
			  <option value="ACCESSORY">악세서리</option>
			  <option value="LIFESTYLE">생활잡화</option>
			  <option value="ETC">기타</option>
			</select>
			
			<label>소분류</label>
			<select id="dCategory" name="dCategory" class="category-select">
			  <option value="">-- 선택 --</option>
			</select>


			</div>
          </div>
        </div>
        <div class="detail-form">
          <textarea id="productDetail" placeholder="판매 물품에 대한 상세 설명을 입력하세요."></textarea>
        </div>
        <div class="submit-section">
          <button id="submit-btn" class="submit-btn">판매 페이지에 상품 등록</button>
        </div>
      </div>

      <!-- 두 번째 세트 -->
      <div class="slide-full">
        <div class="slide-card">
          <div id="img-placeholder1-1" class="img-placeholder"></div>
          <div id="img-placeholder1-2" class="img-placeholder"></div>
          <div id="img-placeholder1-3" class="img-placeholder"></div>
          <div class="product-info">
            <h3>다른 등록 예시</h3><input type="text" id="productName1" placeholder="상품명">
            <p><strong>20,000</strong> 원</p><input type="number" id="price1" placeholder="가격">
            <p>재고 <strong>NN</strong> 개</p><input type="number" id="stock1" placeholder="재고">
            <div class="category">
			  <label>대분류</label>
			  <select id="typeCategory1" class="category-select">
			    <option value="">선택</option>
			    <option value="FOOD">식품</option>
			    <option value="FASHION">패션</option>
			    <option value="LIFE">생활</option>
			  </select>
			
			  <label>중분류</label>
			  <select id="uCategory1" class="category-select">
			    <option value="">선택</option>
			    <option value="SNACK">과자</option>
			    <option value="TOP">상의</option>
			    <option value="FURNITURE">가구</option>
			  </select>
			
			  <label>소분류</label>
			  <select id="dCategory1" class="category-select">
			    <option value="">선택</option>
			    <option value="RICE">쌀</option>
			    <option value="TSHIRT">티셔츠</option>
			    <option value="CHAIR">의자</option>
			  </select>
			</div>
          </div>
        </div>
        <button class="detail-toggle">상세페이지 만들기</button>
        <div class="detail-form" style="display:none;">
          <textarea id="productDetail1" placeholder="판매 물품에 대한 상세 설명을 입력하세요."></textarea>
        </div>
        <div class="submit-section">
          <button id="submit-btn1" class="submit-btn">판매 페이지에 상품 등록</button>
        </div>
      </div>

    </div>
  </div>

  <!-- 슬라이드 버튼 -->
  <button class="slide-arrow right">&gt;</button>
</main>

<footer>
  <div class="footer-inner">
    <div class="footer-logo">뜨락상회</div>
    <p>마음을 모은 생활 복지 플랫폼</p>
    <div class="footer-inputs">
      <input type="text" placeholder="연락처">
      <input type="text" placeholder="연락처2">
    </div>
  </div>
</footer>

<script>

//----------------카테고리----------------------
$(function() {
    const dCategoryOptions = {
      FASHION: [
        { value: "TOP", text: "상의" },
        { value: "BOTTOM", text: "하의" },
        { value: "BAG", text: "가방" },
        { value: "WALLET", text: "지갑" },
        { value: "FASHION_ETC", text: "기타(목도리, 모자, 벨트 등)" }
      ],
      INTERIOR: [
        { value: "DIFFUSER", text: "디퓨저, 캔들" },
        { value: "MOOD_LIGHT", text: "무드등" },
        { value: "FLOWER_PLANT", text: "꽃, 식물" },
        { value: "FURNITURE", text: "가구" }
      ],
      ACCESSORY: [
        { value: "RING", text: "반지" },
        { value: "BRACELET", text: "팔찌" },
        { value: "NECKLACE", text: "목걸이" },
        { value: "KEYRING", text: "키링" }
      ],
      LIFESTYLE: [
        { value: "SOAP", text: "비누" },
        { value: "DISH", text: "그릇" },
        { value: "TABLEWARE", text: "식기류" },
        { value: "CUP", text: "컵" },
        { value: "CASE", text: "케이스" }
      ],
      ETC: [
        { value: "PERFUME", text: "향수" },
        { value: "DOLL", text: "인형" },
        { value: "PET", text: "반려동물" },
        { value: "STATIONERY", text: "문구" }
      ]
    };

    $('#uCategory').on('change', function() {
      const selected = $(this).val();
      const $dCategory = $('#dCategory');

      $dCategory.empty();
      $dCategory.append('<option value="">-- 선택 --</option>');

      if (selected && dCategoryOptions[selected]) {
        $.each(dCategoryOptions[selected], function(_, option) {
          $dCategory.append($('<option></option>').val(option.value).text(option.text));
        });
      }
    });
  });
//---------------슬라이더 작동안되는중----------------------
  $(function() {
    let currentSlide = 0;
    const slides = $('.slide-container .slide-full');
    const container = $('.slide-container');

    function updateSlide() {
      const offset = -currentSlide * 100;
      container.css('transform', `translateX(${offset}%)`);
    }

    $('.slide-arrow.left').click(function () {
      if (currentSlide > 0) {
        currentSlide--;
        updateSlide();
      }
    });

    $('.slide-arrow.right').click(function () {
      if (currentSlide < slides.length - 1) {
        currentSlide++;
        updateSlide();
      }
    });

    $('.detail-toggle').click(function () {
      $(this).next('.detail-form').slideToggle();
    });

    $('#add-category').click(function () {
      $('#category-box').append(`<span class="category-item">카테고리1</span>`);
    });
    $('#add-category2').click(function () {
      $('#category-box2').append(`<span class="category-item">카테고리2</span>`);
    });
    
    //-----------------파일 이름 저장 및 미리보기--------------------
    
	// 파일 이름 변수
	let pimgUrl1 = null, pimgUrl2 = null, pimgUrl3 = null;
	
	// 각 이미지 업로드 이벤트 연결
	for (let i = 1; i <= 3; i++) {
	  // 클릭 시 input 열기
	  $(`#upload-placeholder\${i}`).on('click', function () {
	    $(`#fileInput\${i}`).click();
	  });
	
	  // 파일 선택 시
	  $(`#fileInput\${i}`).on('change', function (e) {
	    const file = e.target.files[0];
	    if (!file) return;
	
	    const allowedExtensions = ['jpg', 'jpeg', 'png', 'gif'];
	    const fileName = file.name.toLowerCase();
	    const extension = fileName.split('.').pop();
	
	    if (!allowedExtensions.includes(extension)) {
	      alert('jpg, jpeg, png, gif 형식의 이미지 파일만 업로드할 수 있습니다.');
	      $(this).val('');  // 파일 선택 초기화
	      return;
	    }
	
	    // 파일 이름 저장
	    if (i === 1) pimgUrl1 = file.name;
	    else if (i === 2) pimgUrl2 = file.name;
	    else if (i === 3) pimgUrl3 = file.name;
	
	    // 미리보기 반영
	    $(`#upload-placeholder\${i}`).html(`<img src="${cpath}/resources/productImages/\${file.name}">`);
	  });
	}
    
    //-------------------상품등록-----------------------
    
    $('#submit-btn').click(function () {
    	  const productName = $('#productName').val().trim();
    	  const productDetail = $('#productDetail').val().trim();
    	  const price = $('#price').val().trim();
    	  const stock = $('#stock').val().trim();
    	  const typeCategoryId = $('#typeCategory').val();
    	  const ucategoryId = $('#uCategory').val();
    	  const dcategoryId = $('#dCategory').val();

    	  if (!productName) {
    	    alert('상품명을 입력해주세요.');
    	    $('#productName').focus();
    	    return;
    	  }
    	  if (!price) {
    	    alert('가격을 입력해주세요.');
    	    $('#price').focus();
    	    return;
    	  }
    	  if (!stock) {
    	    alert('재고를 입력해주세요.');
    	    $('#stock').focus();
    	    return;
    	  }
    	  if (!typeCategoryId) {
    	    alert('대분류를 선택해주세요.');
    	    $('#typeCategory').focus();
    	    return;
    	  }
    	  if (!ucategoryId) {
    	    alert('중분류를 선택해주세요.');
    	    $('#uCategory').focus();
    	    return;
    	  }
    	  if (!dcategoryId) {
    	    alert('소분류를 선택해주세요.');
    	    $('#dCategory').focus();
    	    return;
    	  }
    	  if (!productDetail) {
    	    alert('상세설명을 입력해주세요.');
    	    $('#productDetail').focus();
    	    return;
    	  }

    	  const data = {
    	    productName,
    	    productDetail,
    	    price: parseInt(price),
    	    stock: parseInt(stock),
    	    typeCategoryId,
    	    ucategoryId,
    	    dcategoryId,
    	    pimgUrl1: pimgUrl1,
    	    pimgUrl2: pimgUrl2,
    	    pimgUrl3: pimgUrl3
    	  };

    	  $.ajax({
    	    url: '${cpath}/api/main/sell/sellregister',
    	    method: 'POST',
    	    contentType: 'application/json',
    	    data: JSON.stringify(data),
    	    success: function (response) {
    	    	if(response.status === 201){
    	    		alert('상품 등록이 완료되었습니다.');
    	    	}else{
    	    		alert('상품 등록 실패');
    	    	}
    	      
    	      
    	    },
    	    error: function (xhr) {
    	      alert('상품 등록 실패: ' + xhr.responseText);
    	    }
    	  });
    	});
//--------------------상품등록2---------------------------------------


    
  });
</script>

</body>
</html>
