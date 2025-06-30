package com.chacha.create.controller.buyer.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.service.buyer.notice.StoreNoticeService;

@RestController
@RequestMapping("/api/{storeUrl}")
public class StoreNoticeRestController {
	
	@Autowired
	StoreNoticeService stService;
	
	@GetMapping("/noticelist")
	List<Map<String, Object>> noticeList(@PathVariable String storeUrl){
		return stService.noticeList(storeUrl);
	}
	
	@GetMapping("/noticedetail/{noticeId}")
	List<Map<String, Object>> noticeDetailList(@PathVariable String storeUrl, @PathVariable Integer noticeId){
		return stService.noticeDetailList(storeUrl, noticeId);
	}

}
