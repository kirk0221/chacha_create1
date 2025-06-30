<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>HandCraft Mall - 메인</title>
    <link rel="stylesheet" href="resources/css/main_store.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<div class="main-container">

    <section class="popular-products-section">
        <h2>🔥 인기 상품 TOP 10</h2>
        <div id="popular-products" class="card-grid">
            <!-- Ajax로 상품 카드 10개 삽입 예정 -->
        </div>
    </section>

    <section class="popular-stores-section">
        <h2>🏪 인기 스토어 TOP 10</h2>
        <div id="popular-stores" class="card-grid">
            <!-- Ajax로 스토어 카드 10개 삽입 예정 -->
        </div>
    </section>

</div>

<script src="resources/js/main_store.js"></script>

</body>
</html>
