package com.chacha.create.controller.mainhome.personal;

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

import com.chacha.create.common.dto.product.PersonalProductDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.mainhome.personal.PersonalProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/main/sell")
@Slf4j
public class PersonalProductRestController {
	
	@Autowired
	private PersonalProductService mainproductService;

	@PostMapping(value = "/sellregister", consumes = "application/json", produces = "text/plain;charset=utf-8")
	public int registerProduct(@RequestBody PersonalProductDTO dto, HttpSession session) {
		MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
		Integer memberId = loginMember.getMemberId();
		log.info("로그인된 memberId: {}", memberId);
		int result = mainproductService.insertMainProductWithImages(dto, memberId);

		return result;
	}

	@GetMapping(value = "/productlist", produces = "application/json;charset=utf-8")
	public List<PersonalProductDTO> getProductsBySeller(HttpSession session) {
		MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
		Integer memberId = loginMember.getMemberId();
		log.info("로그인된 memberId: {}", memberId);
		return mainproductService.getProductsByMemberId(memberId);
	}

	@PutMapping(value = "/sellregister/update", consumes = "application/json", produces = "text/plain;charset=utf-8")
	public int updateProduct(@RequestBody PersonalProductDTO dto, HttpSession session) {
		MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
		Integer memberId = loginMember.getMemberId();
		log.info("로그인된 memberId: {}", memberId);
		int result = mainproductService.updateMainProductWithImages(dto, memberId);
		return result;
	}

	@PutMapping(value = "/sellregister/delete", consumes = "application/json", produces = "text/plain;charset=utf-8")
	public int deleteProduct(@RequestBody Map<String, Integer> param, HttpSession session) {
		int productId = param.get("productId");
		MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
		Integer memberId = loginMember.getMemberId();
		log.info("로그인된 memberId: {}", memberId);
		int result = mainproductService.deleteMainProduct(productId, memberId);

		return result;
	}
}

