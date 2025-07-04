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
let socket = null;
let currentRoomId = null;

$(document).ready(function() {
    // 채팅방 목록 불러오기
    $.ajax({
        url: '${cpath}/api/main/message/chatrooms',
        method: 'GET',
        success: function(response) {
            if (response.status === 200) {
                const chatrooms = response.data;
                const $list = $("#chat-room-list");
                $list.empty();

                chatrooms.forEach(room => {
                    const itemHtml = `
                        <li class="chat-room-item" data-room-id="\${room.chatroomId}" data-store-url="\${room.storeUrl}">
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

    // 채팅방 클릭 시 WebSocket 연결
    $(document).on('click', '.chat-room-item', function() {
        currentRoomId = $(this).data('room-id');

        // 기존 연결 닫기
        if (socket) {
            socket.close();
        }

        // WebSocket 연결 생성
        
        socket = new WebSocket(`${location.origin.replace("http", "ws")}/create/chatserver?chatroomId=2`);
        // socket = new WebSocket('${pageContext.request.scheme}://localhost:9999${pageContext.request.contextPath}/chatserver?chatroomId=' + currentRoomId);
        // socket = new WebSocket('ws://localhost:9999/create/chatserver?chatroomId=' + currentRoomId);

        socket.onopen = function() {
            console.log('WebSocket 연결됨: ' + currentRoomId);
            $(".chat-messages").empty(); // 이전 메시지 초기화 (선택 사항)
        };

        socket.onmessage = function(event) {
            const msg = JSON.parse(event.data);
            const messageHtml = `
                <div class="message received">
                    <p class="message-text">\${msg.message}</p>
                    <span class="message-time">\${msg.time}</span>
                </div>
            `;
            $(".chat-messages").append(messageHtml);
        };

        socket.onclose = function() {
            console.log("WebSocket 닫힘");
        };

        socket.onerror = function(error) {
            console.error("WebSocket 오류", error);
        };
    });

    // 메시지 전송
    $(".chat-input button").on("click", function() {
        const message = $(".chat-input input").val().trim();
        if (!message || !socket || socket.readyState !== WebSocket.OPEN) {
            alert("메시지를 보낼 수 없습니다. 채팅방을 먼저 선택하세요.");
            return;
        }

        const sendData = {
            roomId: currentRoomId,
            message: message
        };

        socket.send(JSON.stringify(sendData));

        const messageHtml = `
            <div class="message sent">
                <p class="message-text">\${message}</p>
                <span class="message-time">지금</span>
            </div>
        `;
        $(".chat-messages").append(messageHtml);
        $(".chat-input input").val('');
    });
});
</script>

</body>
</html>