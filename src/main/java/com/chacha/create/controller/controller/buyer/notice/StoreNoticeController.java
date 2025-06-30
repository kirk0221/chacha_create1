package com.chacha.create.controller.controller.buyer.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("{storeUrl}")
public class StoreNoticeController {

	
	@GetMapping("/notices")
	public String sellernotice() {
		return ("/main/main_notice");
	}
	
	@GetMapping("/noticedetail/{noticeId}")
	public String sellernoticedetail() {
		return ("/main/main_notice");
	}
}
