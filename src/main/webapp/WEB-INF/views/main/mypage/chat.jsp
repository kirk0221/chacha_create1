<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<%@ include file="/common/main_nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>채팅방</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/store/seller/authmain.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/store/chat.css">
  <script src="https://code.iconify.design/iconify-icon/1.0.8/iconify-icon.min.js"></script>
  
</head>
<body>
<div class="wrapper">

  <div class="main-area">
    <div class="content-wrapper">
      
     <%@ include file="/common/main_mypage_sidenav.jsp" %>

      <!-- 메인 콘텐츠 (chat.jsp 내용) -->
      <main class="content">
        <div class="content-inner">
          
          <div class="chat-container">

            <!-- 채팅방 목록 -->
            <div class="chat-sidebar">
              <h2>채팅방</h2>
              <div class="chat-search">
                <input type="text" placeholder="채팅방 검색">
              </div>
              <ul id="chat-room-list" class="chat-room-list">
              </ul>
            </div>

            <!-- 채팅방 내용 -->
            <div class="chat-main">
              <div class="chat-header">
                <h3>차팀장</h3>
              </div>
              <div class="chat-messages">
                <div class="message received">
                  <p class="message-text">천 조원 잘 되어가나요?</p>
                  <span class="message-time">8:00 PM</span>
                </div>
                <div class="message received">
                  <p class="message-text">너 나약하지 않잖아</p>
                  <span class="message-time">8:00 PM</span>
                </div>
                <div class="message sent">
                  <p class="message-text">차팀장 님 도저히 못 하겠어요</p>
                  <span class="message-time">8:01 PM</span>
                </div>
                <div class="message sent">
                  <p class="message-text">제발 그만</p>
                  <span class="message-time">8:01 PM</span>
                </div>
              </div>
              <div class="chat-input">
                <input type="text" placeholder="메시지를 입력하세요">
                <button>전송</button>
              </div>
            </div>

          </div>

        </div>
      </main>

    </div>
  </div>

  <footer>&copy; 2025 뜨락상회</footer>
</div>

<script>
$(document).ready(function() {
    $.ajax({
        url: '${cpath}/api/main/message/chatrooms',
        method: 'GET',
        success: function(response) {
        	if (response.status === 200) {
                const chatrooms = response.data;
                const $list = $("#chat-room-list");
                $list.empty(); // 기존 리스트 제거

                chatrooms.forEach(room => {
                	console.log(room);
                    const itemHtml = `
                        <li class="chat-room-item">
                            <div class="chat-room-name">\${room.storeName}</div>
                            <div class="chat-room-preview">\${room.chattingText}</div>
                        </li>
                    `;
                    $list.append(itemHtml);
                });
            } else {
                alert("채팅방 목록을 불러오지 못했습니다.");
            }
        },
        error: function() {
            alert("서버 오류 발생");
        }
    });
});
</script>
</body>
</html>