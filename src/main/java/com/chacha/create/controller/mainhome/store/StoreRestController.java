package com.chacha.create.controller.mainhome.store;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.service.mainhome.store.StoreService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/main/store")
public class StoreRestController {
	
	@Autowired
	StoreService storeCreateService;
	
	@GetMapping("/storelist")
	public List<StoreEntity> storelist(){
		return storeCreateService.selectAll();
	}
	
	@PutMapping("/openform")
	public int storecreate(HttpSession session, @RequestBody StoreEntity storeEntity) {
		int result = 0;
		MemberEntity memberEntity = (MemberEntity) session.getAttribute("loginMember");
		log.info("로그인 사용자 : " + memberEntity.toString() + "입력받은 스토어 정보 : " + storeEntity.toString());
		result = storeCreateService.storeUpdate(storeEntity, memberEntity);
		return result;
	}
	
	
}
