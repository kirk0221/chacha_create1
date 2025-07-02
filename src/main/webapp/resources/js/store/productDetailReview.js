document.addEventListener("DOMContentLoaded", () => {
  const pathSegments = window.location.pathname.split("/");
  const storeUrl = pathSegments[2];
  const productId = pathSegments[4];
  const cpath = document.body.getAttribute("data-cpath") || "";
  const apiUrl = `${cpath}/api/${storeUrl}/productdetail/${productId}`;

  // 리뷰 목록 불러오기
  loadReviews(storeUrl, productId, cpath);

  // 등록 버튼 이벤트 연결
  document.getElementById("review-submit-btn").addEventListener("click", () => {
    const content = document.getElementById("review-input").value.trim();
    if (!content) {
      alert("리뷰 내용을 입력하세요.");
      return;
    }

    addReview(storeUrl, productId, cpath, content, 123); // orderDetailId는 임시
    document.getElementById("review-input").value = "";
  });

  const loggedInMemberId = window.loggedInMemberId || null;

  function loadReviews(storeUrl, productId, cpath) {
    $.ajax({
      url: `${cpath}/api/${storeUrl}/productdetail/${productId}/review`,
      method: "GET",
      dataType: "json",
      success: function (data) {
        const reviewList = document.querySelector(".review-list");
        reviewList.innerHTML = "";

        data.data.forEach(review => {
          const isMyReview = loggedInMemberId && review.memberId === loggedInMemberId;

          const reviewItem = document.createElement("div");
          reviewItem.className = "review-item";
          reviewItem.dataset.reviewId = review.reviewId;

          reviewItem.innerHTML = `
            <div class="review-header">
              <div class="review-meta">
                <span class="review-writer">${review.memberName || "익명"}</span>
                <span class="review-date">${new Date(review.reviewDate).toLocaleDateString()}</span>
              </div>
              <div class="review-buttons">
                ${
                  isMyReview
                    ? `<button class="review-edit-btn">수정</button>
                       <button class="review-delete-btn">삭제</button>`
                    : `<button class="review-report-btn">신고</button>`
                }
              </div>
            </div>
            <div class="review-content">${review.reviewText}</div>
          `;

          reviewList.appendChild(reviewItem);

          if (isMyReview) {
            bindReviewEvents(reviewItem);
          } else {
            const reportBtn = reviewItem.querySelector(".review-report-btn");
            if (reportBtn) {
              reportBtn.addEventListener("click", () => {
                alert("신고 기능은 준비 중입니다.");
              });
            }
          }
        });
      },
      error: function (xhr) {
        console.error(xhr);
        alert("리뷰 목록을 불러오지 못했습니다.");
      }
    });
  }

  function addReview(storeUrl, productId, cpath, content, orderDetailId) {
	  $.ajax({
	    url: `${cpath}/api/${storeUrl}/productdetail/${productId}/review`,
	    method: "POST",
	    contentType: "application/json",
	    data: JSON.stringify({
	      reviewContent: content,
	      orderDetailId: orderDetailId
	    }),
	    success: function (res) {
	      if (res.result === "success") {
	        loadReviews(storeUrl, productId, cpath);
	        alert("리뷰가 등록되었습니다.");
	      } else {
	        alert(res.message || "리뷰 등록 실패");
	      }
	    },
	    error: function (xhr) {
	      console.error(xhr);
	      alert("리뷰 등록 실패 (서버 오류)");
	    }
	  });
	}

  function updateReview(storeUrl, productId, cpath, reviewId, content) {
    $.ajax({
      url: `${cpath}/api/${storeUrl}/productdetail/${productId}/review`,
      method: "PUT",
      contentType: "application/json",
      data: JSON.stringify({
        reviewId: reviewId,
        reviewContent: content
      }),
      success: function () {
        loadReviews(storeUrl, productId, cpath);
        alert("리뷰가 수정되었습니다.");
      },
      error: function (xhr) {
        console.error(xhr);
        alert("리뷰 수정 실패");
      }
    });
  }

  function deleteReview(storeUrl, productId, cpath, reviewId) {
    $.ajax({
      url: `${cpath}/api/${storeUrl}/productdetail/${productId}/review`,
      method: "DELETE",
      data: { reviewId: reviewId },
      success: function () {
        loadReviews(storeUrl, productId, cpath);
        alert("리뷰가 삭제되었습니다.");
      },
      error: function (xhr) {
        console.error(xhr);
        alert("리뷰 삭제 실패");
      }
    });
  }

  function bindReviewEvents(container) {
    const editBtn = container.querySelector(".review-edit-btn");
    const deleteBtn = container.querySelector(".review-delete-btn");

    if (editBtn) {
      editBtn.addEventListener("click", () => {
        const contentEl = container.querySelector(".review-content");
        const originalContent = contentEl.textContent.trim();
        contentEl.style.display = "none";

        const buttonsDiv = container.querySelector(".review-buttons");
        buttonsDiv.innerHTML = `
          <button class="review-save-btn">저장</button>
          <button class="review-cancel-btn">취소</button>
        `;

        const textarea = document.createElement("textarea");
        textarea.className = "review-edit-input";
        textarea.value = originalContent;
        container.appendChild(textarea);

        buttonsDiv.querySelector(".review-save-btn").addEventListener("click", () => {
          const newContent = textarea.value.trim();
          if (!newContent) {
            alert("리뷰 내용을 입력하세요.");
            return;
          }
          updateReview(storeUrl, productId, cpath, container.dataset.reviewId, newContent);
          textarea.remove();
          contentEl.style.display = "block";
          restoreButtons(container);
        });

        buttonsDiv.querySelector(".review-cancel-btn").addEventListener("click", () => {
          textarea.remove();
          contentEl.style.display = "block";
          restoreButtons(container);
        });
      });
    }

    if (deleteBtn) {
      deleteBtn.addEventListener("click", () => {
        if (confirm("리뷰를 삭제하시겠습니까?")) {
          deleteReview(storeUrl, productId, cpath, container.dataset.reviewId);
        }
      });
    }
  }

  function restoreButtons(container) {
    const buttonsDiv = container.querySelector(".review-buttons");
    buttonsDiv.innerHTML = `
      <button class="review-edit-btn">수정</button>
      <button class="review-delete-btn">삭제</button>
    `;
    bindReviewEvents(container);
  }
});
