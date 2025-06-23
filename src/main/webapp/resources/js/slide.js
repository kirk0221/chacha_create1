document.addEventListener("DOMContentLoaded", function () {
    const slider = document.getElementById('store-slider');
    const slideLeft = document.getElementById('slideLeft');
    const slideRight = document.getElementById('slideRight');

    let currentSlide = 0;
    const itemWidth = 430; // 400px + 30px gap
    const visibleItems = 3;
    const totalItems = slider.children.length;
    const maxSlide = totalItems - visibleItems;

    slideLeft.addEventListener('click', () => {
        if (currentSlide > 0) {
            currentSlide--;
            slider.style.transform = `translateX(-${currentSlide * itemWidth}px)`;
        }
    });

    slideRight.addEventListener('click', () => {
        if (currentSlide < maxSlide) {
            currentSlide++;
            slider.style.transform = `translateX(-${currentSlide * itemWidth}px)`;
        }
    });
});
