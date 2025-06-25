package com.chacha.create.controller.buyer.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.service.buyer.main.StoreNoticeService;

@RestController
@RequestMapping("/{storeUrl}")
public class StoreNoticeController {
	
	@Autowired
	StoreNoticeService stService;
	
	@GetMapping("/noticelist")
	List<Map<String, Object>> noticeList(@PathVariable String storeUrl){
		return stService.noticeList(storeUrl);
	}

}
