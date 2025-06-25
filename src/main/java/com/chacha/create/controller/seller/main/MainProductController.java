package com.chacha.create.controller.seller.main;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.dto.product.MainProductDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.mainhome.store.MainProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/main/sell")
@Slf4j
public class MainProductController {
	
	@Autowired
	private MainProductService mainproductService;

	@PostMapping(value = "/sellregister", consumes = "application/json", produces = "text/plain;charset=utf-8")
	public String registerProduct(@RequestBody MainProductDTO dto, HttpSession session) {
		int result = mainproductService.insertMainProductWithImages(dto, session);

		switch (result) {
			case 1:
				return "상품 등록 성공";
			case -1:
				return "로그인 정보 없음 - 등록 실패";
			default:
				return "상품 등록 실패";
		}
	}

	@GetMapping(value = "/productlist", produces = "application/json;charset=utf-8")
	public List<MainProductDTO> getProductsBySeller(HttpSession session) {
		Object loginMember = session.getAttribute("loginMember");
		if (loginMember == null) {
			log.warn("로그인 정보 없음 (session에 loginMember 없음)");
			return Collections.emptyList();
		}

		Integer memberId = ((MemberEntity) loginMember).getMemberId();
		log.info("로그인된 memberId: {}", memberId);

		return mainproductService.getProductsByMemberId(memberId);
	}

	@PutMapping(value = "/sellregister/update", consumes = "application/json", produces = "text/plain;charset=utf-8")
	public String updateProduct(@RequestBody MainProductDTO dto, HttpSession session) {
		int result = mainproductService.updateMainProductWithImages(dto, session);

		switch (result) {
			case 1:
				return "상품 수정 성공";
			case -1:
				return "로그인 정보 없음 - 수정 실패";
			case -2:
				return "권한 없음 - 수정 실패";
			default:
				return "상품 수정 실패";
		}
	}

	@PutMapping(value = "/sellregister/delete", consumes = "application/json", produces = "text/plain;charset=utf-8")
	public String deleteProduct(@RequestBody Map<String, Integer> param, HttpSession session) {
		int productId = param.get("productId");
		int result = mainproductService.deleteMainProduct(productId, session);

		switch (result) {
			case 1:
				return "상품 삭제 성공";
			case -1:
				return "로그인 정보 없음 - 삭제 실패";
			case -2:
				return "권한 없음 - 삭제 실패";
			default:
				return "상품 삭제 실패";
		}
	}
}

