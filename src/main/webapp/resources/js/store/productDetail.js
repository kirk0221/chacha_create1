document.addEventListener("DOMContentLoaded", function () {
  const pathSegments = window.location.pathname.split("/");
  const storeUrl = pathSegments[2];
  const productId = pathSegments[4];
  const cpath = document.body.getAttribute("data-cpath") || "";
  const apiUrl = `${cpath}/api/${storeUrl}/productdetail/${productId}`;

  function getImageUrl(imgPath) {
    if (!imgPath) return "";
    if (imgPath.startsWith("http://") || imgPath.startsWith("https://")) {
      return imgPath;
    }
    return `${cpath}/resources/productImages/${imgPath}`;gi
  }

  $.ajax({
    url: apiUrl,
    method: "GET",
    dataType: "json",
    success: function (res) {
      const detail = res.data;
      const product = detail.productDetail;

      document.getElementById("productTitle").textContent = product.productName;
      document.getElementById("productTypeCategory").textContent = product.typeCategoryName;
      document.getElementById("productUCategory").textContent = product.ucategoryName;
      document.getElementById("productDCategory").textContent = product.dcategoryName;

      const storeLink = document.getElementById("storeNameLink");
      if (storeLink) {
        storeLink.href = `${cpath}/store/info`;
        storeLink.textContent = product.storeName;
      }

      const priceElement = document.getElementById("productPrice");
      const unitPrice = product.price;
      let quantity = 1;
      const maxQuantity = product.stock;

      const updateTotalPrice = () => {
        priceElement.textContent = `${(unitPrice * quantity).toLocaleString()} 원`;
      };

      const mainImg = document.querySelector(".main-image img");
      const thumbRow = document.getElementById("thumbnailRow");
      mainImg.src = getImageUrl(detail.mainThumbnailUrl);
      thumbRow.innerHTML = "";

      detail.thumbnailImageUrls.forEach(imgName => {
        const img = document.createElement("img");
        img.src = getImageUrl(imgName);
        img.alt = "썸네일";
        img.classList.add("thumbnail");
        thumbRow.appendChild(img);
      });

      const detailImgContainer = document.querySelector(".img-ex");
      detailImgContainer.innerHTML = "";
      detail.descriptionImageUrls.forEach(imgName => {
        const img = document.createElement("img");
        img.src = getImageUrl(imgName);
        img.classList.add("detail-img");
        detailImgContainer.appendChild(img);
      });

      document.querySelector(".detail-text-middle").innerHTML = `<b>${product.productDetail}</b>`;

      const minusBtn = document.querySelector(".quantity-btn.minus");
      const plusBtn = document.querySelector(".quantity-btn.plus");
      const display = document.querySelector(".quantity-display");

      const updateDisplay = () => {
        display.textContent = quantity;
        updateTotalPrice();
      };

      minusBtn.addEventListener("click", () => {
        if (quantity > 1) {
          quantity--;
          updateDisplay();
        }
      });

      plusBtn.addEventListener("click", () => {
        if (quantity < maxQuantity) {
          quantity++;
          updateDisplay();
        }
      });

      updateDisplay();

      document.addEventListener("click", function (e) {
        if (e.target.classList.contains("thumbnail")) {
          mainImg.src = e.target.src;
        }
      });

      const cartBtn = document.querySelector(".cart-button");
      cartBtn.addEventListener("click", function () {
        const totalPrice = unitPrice * quantity;
        const targetUrl = `${cpath}/main/mypage/cart?productId=${product.productId}&quantity=${quantity}&totalPrice=${totalPrice}`;
        location.href = targetUrl;
      });
    },
    error: function (xhr, status, error) {
      console.error("상품 정보 로딩 실패:", error);
      alert("상품 정보를 불러오지 못했습니다.");
    }
  });
});
