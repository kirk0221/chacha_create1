<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav>
  <div class="nav-inner container-1440">
    <div class="logo">
      <!-- ✅ 로고 클릭 시 메인으로 이동 -->
      <a href="${pageContext.request.contextPath}/views/main/main_test.jsp">
        <img src="resources/images/logo/logohorizon_green.png" alt="뜨락상회 로고" style="height: 80px" />
      </a>
    </div>
    <div class="menu">
      <a href="#" class="nav-item ">전체상품</a>
      <a href="#" class="nav-item">스토어</a>
      <a href="#" class="nav-item">공지/소식</a>
      <a href="#" class="nav-item">개인판매</a>
      <a href="#" class="nav-item">클래스</a>
      <a href="#" class="nav-item">마이페이지</a>
      <a href="#" class="nav-item">장바구니</a>
    </div>
  </div>
</nav>

<style>
nav {
  background-color: #ffffff;
  border-bottom: 1px solid #ccc;
}

.nav-inner {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 80px;
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
  font-family: 'Jua', sans-serif;
}

.menu .nav-item:hover {
  color: #1b2e23;
}

.menu .nav-item.active {
  font-weight: bold;
  color: #2D4739;
}

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

<script>
  const navItems = document.querySelectorAll(".nav-item");
  navItems.forEach(item => {
    item.addEventListener("click", function () {
      navItems.forEach(el => el.classList.remove("active"));
      this.classList.add("active");
    });
  });
</script>
