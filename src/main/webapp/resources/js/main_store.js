$(document).ready(function() {
    // 인기 상품 불러오기
    $.ajax({
        url: '/api/main/popular-products',
        method: 'GET',
        success: function(products) {
            let html = '';
            products.forEach(p => {
                html += `
                <div class="card">
                    <img src="${p.thumbnailUrl}" alt="${p.productName}">
                    <h3>${p.productName}</h3>
                    <p>❤️ ${p.likeCount} 좋아요</p>
                </div>`;
            });
            $('#popular-products').html(html);
        },
        error: function() {
            $('#popular-products').html('<p>인기 상품을 불러오지 못했습니다.</p>');
        }
    });

    // 인기 스토어 불러오기
    $.ajax({
        url: '/api/main/popular-stores',
        method: 'GET',
        success: function(stores) {
            let html = '';
            stores.forEach(s => {
                html += `
                <div class="card">
                    <img src="${s.profileImageUrl}" alt="${s.storeName}">
                    <h3>${s.storeName}</h3>
                    <p>⭐ ${s.rating.toFixed(1)} 평점</p>
                </div>`;
            });
            $('#popular-stores').html(html);
        },
        error: function() {
            $('#popular-stores').html('<p>인기 스토어를 불러오지 못했습니다.</p>');
        }
    });
});
