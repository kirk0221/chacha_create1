<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뜨락상회 관리자 페이지</title>
<link rel="stylesheet" type="text/css" href="resources/css/mainauth_style.css">
<link rel="stylesheet" type="text/css" href="resources/css/suggestion_style.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<div class="wrapper">

<header>
    <div class="header-inner">
        <div class="login-bar">
            <span>관리자님 반갑습니다.</span>
            <button class="logout-btn">로그아웃</button>
        </div>
    </div>
</header>

<div class="main-area">
	<div class="content-wrapper"> 
    <nav class="sidebar">
        <ul>
            <li class="has-submenu">
                <a href="javascript:void(0);">판매자 정산 관리 ▼</a>
                <ul class="submenu">
                    <li><a href="#">스토어 정산 관리</a></li>
                    <li><a href="#">개인 판매자 정산 관리</a></li>
                </ul>
            </li>

            <li class="has-submenu">
                <a href="javascript:void(0);">건의/신고 관리 ▼</a>
                <ul class="submenu">
                    <li><a href="#">건의사항</a></li>
                    <li><a href="#">신고</a></li>
                </ul>
            </li>

            <li><a href="#">스토어 관리</a></li>
            <li><a href="#">회원 관리</a></li>
        </ul>
    </nav>
    
    <main class="content">
        <div class="content-inner">

            <div class="suggestion-content">
                <h2>건의사항 관리</h2>

                <div class="suggestion-table">
                    <table>
                        <thead>
                            <tr>
                                <th>건의자명</th>
                                <th>건의 제목</th>
                                <th>건의 내용</th>
                                <th>건의 카테고리</th>
                                <th>작성일</th>
                                <th>건의 처리하기</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- 10개 미리보기 -->
                            <% for (int i = 1; i <= 10; i++) { 
                                String fullContent = "이것은 사용자" + i + "의 매우 긴 건의 내용입니다. 관리자님, 이 기능을 개선해주셨으면 합니다. 자세한 설명이 이어집니다."; 
                            %>
                            <tr>
                                <td>사용자<%= i %></td>
                                <td>기능 개선 요청</td>
                                <td>
                                    <div class="content-box" data-full="<%= fullContent %>">
                                        <span class="preview-text"></span>
                                        <button class="toggle-detail-btn">▼</button>
                                    </div>
                                </td>
                                <td>시스템 개선</td>
                                <td>2025-06-24</td>
                                <td><button class="open-modal-btn">메시지 전송</button></td>
                            </tr>
                            <% } %>

                            <!-- 나머지 숨김 20개 -->
                            <% for (int i = 11; i <= 30; i++) { 
                                String fullContent = "이것은 사용자" + i + "의 건의 내용입니다. 더 많은 설명과 요구사항이 포함되어 있습니다.";
                            %>
                            <tr class="extra-row" style="display:none;">
                                <td>사용자<%= i %></td>
                                <td>기능 개선 요청</td>
                                <td>
                                    <div class="content-box" data-full="<%= fullContent %>">
                                        <span class="preview-text"></span>
                                        <button class="toggle-detail-btn">▼</button>
                                    </div>
                                </td>
                                <td>프로세스 개선</td>
                                <td>2025-06-23</td>
                                <td><button class="open-modal-btn">메시지 전송</button></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>

                <div class="more-button-box">
                    <button id="showMoreBtn">▼ 전체 보기</button>
                </div>

            </div>

        </div>
    </main>
</div>
</div>

<footer>
    &copy; 2025 뜨락상회
</footer>
</div>

<!-- 모달창 -->
<div id="messageModal" class="modal">
    <div class="modal-content">
        <h3>건의 처리 메시지 작성</h3>
        <label>제목:</label>
        <input type="text" id="modal-title" placeholder="제목을 입력하세요">
        <label>내용:</label>
        <textarea id="modal-content" placeholder="내용을 입력하세요"></textarea>
        <div class="modal-buttons">
            <button id="modal-cancel">취소</button>
            <button id="modal-submit">등록</button>
        </div>
    </div>
</div>

<script>
$(document).ready(function() {
    $('.has-submenu > a').click(function() {
        $(this).next('.submenu').slideToggle(200);
    });

    // 더보기 (전체 보기)
    $('#showMoreBtn').click(function() {
        $('.extra-row').slideDown(200);
        $(this).hide();
    });

    // 초기 프리뷰 생성 (30자까지만 자르기)
    $('.content-box').each(function() {
        var full = $(this).data('full');
        var preview = full.length > 30 ? full.substring(0, 30) + "..." : full;
        $(this).find('.preview-text').text(preview);
    });

    // 토글 상세보기
    $('.toggle-detail-btn').click(function() {
        var box = $(this).closest('.content-box');
        var full = box.data('full');
        if ($(this).text() == "▼") {
            box.find('.preview-text').text(full);
            $(this).text("▲");
        } else {
            var preview = full.length > 30 ? full.substring(0, 30) + "..." : full;
            box.find('.preview-text').text(preview);
            $(this).text("▼");
        }
    });

    // 모달 열기/닫기
    $('.open-modal-btn').click(function() {
        $('#messageModal').fadeIn();
    });
    $('#modal-cancel').click(function() {
        $('#messageModal').fadeOut();
    });
    $('#modal-submit').click(function() {
        alert("메시지 전송 완료!");
        $('#messageModal').fadeOut();
    });
});
</script>

</body>
</html>
