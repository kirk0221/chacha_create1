package com.chacha.create.controller.controller.seller.main;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.chacha.create.common.dto.product.ProductWithImagesDTO;
import com.chacha.create.common.entity.product.ProductEntity;
import com.chacha.create.common.enums.category.DCategoryEnum;
import com.chacha.create.common.enums.category.TypeCategoryEnum;
import com.chacha.create.common.enums.category.UCategoryEnum;
import com.chacha.create.service.seller.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// productDetail 오류

@Slf4j
@Controller
@RequestMapping("/{storeUrl}/seller")
@RequiredArgsConstructor
public class SellerMainController {
	
	
	final ProductService productService;
	// 판매자 메인페이지
	@GetMapping("/main")
	public String showMainPage(@PathVariable String storeUrl, Model model) {
		return "store/seller/sellerMyPage";
	 }
	
	@GetMapping("/productinsert")
	public String showProductInsertForm(@PathVariable String storeUrl, Model model) {
	    model.addAttribute("typeCategories", TypeCategoryEnum.values());
	    model.addAttribute("uCategories", UCategoryEnum.values());

	    // ✅ dCategory를 uCategory 기준으로 그룹핑해서 Map에 담기
	    Map<Integer, List<Map<String, Object>>> dCategoriesByU = Arrays.stream(DCategoryEnum.values())
	    	    .collect(Collectors.groupingBy(
	    	        d -> d.getUcategory().getId(),  // key: uCategoryId
	    	        Collectors.mapping(d -> {
	    	            Map<String, Object> map = new HashMap<>();
	    	            map.put("id", d.getId());
	    	            map.put("name", d.getName());
	    	            return map;
	    	        }, Collectors.toList())
	    	    ));

	    model.addAttribute("dCategoriesByU", dCategoriesByU); // ✅ Map<Integer, List<id-name>> 형태
	    model.addAttribute("storeUrl", storeUrl);

	    return "store/seller/productInsert";
	}
	
	@PostMapping(value = "productinsert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseEntity<?> upload(
	    @PathVariable String storeUrl,
	    @RequestPart("dtoList") List<ProductWithImagesDTO> dtoList,
	    MultipartHttpServletRequest request
	) {
	    for (int i = 0; i < dtoList.size(); i++) {
	        List<MultipartFile> images = request.getFiles("dtoList[" + i + "].images");
	        dtoList.get(i).setImages(images);
	    }

	    for (ProductWithImagesDTO dto : dtoList) {
	        System.out.println("✔ product: " + dto.getProduct());
	        System.out.println("✔ images: " + dto.getImages());
	    }

	    int successCount = productService.registerMultipleProductsWithImages(storeUrl, dtoList);
	    if (successCount == dtoList.size()) {
	        return ResponseEntity.ok("모든 상품 등록 성공");
	    } else if (successCount > 0) {
	        return ResponseEntity.ok(successCount + "개 등록 성공, 일부 실패");
	    } else {
	        return ResponseEntity.badRequest().body("등록 실패");
	    }
	}

	
	@GetMapping("/products")
	public String showProductListPage(@PathVariable String storeUrl, Model model) {
	    // DB에서 해당 스토어 상품 리스트 조회 서비스 호출
	    List<ProductEntity> productList = productService.getProductsByStore(storeUrl);
	    model.addAttribute("productList", productList);
	    model.addAttribute("storeUrl", storeUrl);
	    return "store/seller/productSelect";  // 이 JSP에서 productList를 화면에 뿌림
	}
	
	// 판매 상품 상세 보기
	@GetMapping("/productdetail/{productId}")
    public String showProductDetailPage(@PathVariable String storeUrl,
                                        @PathVariable int productId,
                                        Model model) {
        return "store/productDetail";
	}
	
	// 판매 상품 수정
	@GetMapping("/productupdate/{productId}")
    public String showProductUpdatePage(@PathVariable String storeUrl,
                                        @PathVariable int productId,
                                        Model model) {
        return "store/seller/productUpdate";
	}
	
	// 판매 정산 관리
		@GetMapping("/management/settlement")
	    public String showSellrSettlementPage(@PathVariable String storeUrl,
	                                        Model model) {
	        return "store/seller/sellerSettlement";
		}
	
	// 판매 주문 목록 --- 추가 필요
//	@GetMapping("/management/order")
//	public String showOrderPage() {
//		return "";
//	}
	
	// 판매 리뷰 관리
	@GetMapping("/reviews")
	public String showReviewPage() {
		return "store/seller/sellerReview";
	}
	
	// 문의 메시지
	@GetMapping("/chat")
	public String showChatPage() {
		return "store/chat";
	}
	
	// 스토어 관리 --- 추가 필요
//	@GetMapping("/management/seller")
//	public String storeManagement() {
//		return "";
//	}
	
	// 공지사항목록
	@GetMapping("/management/notices")
	public String showNoticePage() {
		return "store/seller/sellerNotice";
	}
	
	// 폐업
	@GetMapping("/close")
	public String showDonePage() {
		return "store/seller/storeClose";
	}
	
	private String fileStorageSave(MultipartFile file) throws IOException {
	    // 실제로는 서버에 파일 저장하는 경로, UUID 등 활용해 고유 파일명으로 저장 권장
	    String originalFileName = file.getOriginalFilename();
	    String extension = "";

	    if (originalFileName != null && originalFileName.contains(".")) {
	        extension = originalFileName.substring(originalFileName.lastIndexOf("."));
	    }

	    // 예: UUID + 확장자
	    String newFileName = UUID.randomUUID().toString() + extension;

	    // 저장 경로 (서버 로컬 경로나 AWS S3 등)
	    Path uploadPath = Paths.get("C:/upload/product"); // 예시, 실제 경로 맞게 수정
	    if (!Files.exists(uploadPath)) {
	        Files.createDirectories(uploadPath);
	    }

	    Path filePath = uploadPath.resolve(newFileName);
	    file.transferTo(filePath.toFile());

	    return newFileName;
	}
	
}
