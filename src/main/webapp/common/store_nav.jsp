<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Google Fonts: jua -->
<link href="https://fonts.googleapis.com/css2?family=Cute+Font&family=Jua&display=swap" rel="stylesheet">



<style>

body {
  font-family: "Jua", sans-serif;
  font-weight: 400;
  font-style: normal;
}

nav {
  background-color: #ffffff;
  border-bottom: 1px solid #ccc;
}

.nav-inner {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 60px;
  padding: 0 240px;
}

.menu .nav-item {
  margin: 0 10px;
  text-decoration: none;
  color: #2D4739;
  font-size: 18px;
  padding: 10px 8px;
  position: relative;
  transition: all 0.3s ease;
}

.menu .nav-item:hover {
  color: #1b2e23;
}

/* 선택된 항목 스타일 */
.menu .nav-item.active {
  font-weight: bold;
  color: #2D4739;
}

/* 밑줄 효과 */
.menu .nav-item.active::after {
  content: "";
  position: absolute;
  bottom: 5px;
  left: 0;
  width: 100%;
  height: 2px;
  background-color: #2D4739;
  border-radius: 1px;
}
</style>
</head>
<body>
<nav>
  <div class="nav-inner container-1440">
    <div class="logo">
      <img src="resources/images/logo/logohorizon_green.png" alt="뜨락상회 로고" style="height: 80px" />
    </div>
    <div class="menu">
      <a href="#" class="nav-item active">전체상품</a>
      <a href="#" class="nav-item">스토어</a>
      <a href="#" class="nav-item">공지/소식</a>
      <a href="#" class="nav-item">마이페이지</a>
      <a href="#" class="nav-item">상회 돌아가기</a>
      <a href="#" class="nav-item">장바구니</a>
    </div>
  </div>
</nav>

<script>
  const navItems = document.querySelectorAll(".nav-item");
  navItems.forEach(item => {
    item.addEventListener("click", function () {
      navItems.forEach(el => el.classList.remove("active"));
      this.classList.add("active");
    });
  });
</script>
</body>
</html>
