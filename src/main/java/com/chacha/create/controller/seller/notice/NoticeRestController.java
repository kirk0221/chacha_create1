package com.chacha.create.controller.seller.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.store.NoticeEntity;
import com.chacha.create.service.seller.notice.NoticeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/{storeUrl}/management")
public class NoticeRestController {

	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/noticelist")
	public List<NoticeEntity> noticelist(){
		return noticeService.selectForNoticeAll();
	}
	
	@GetMapping("/noticedetail")
	public NoticeEntity noticedetail(int noticeId){
		return noticeService.selectByNoticeId(noticeId);
	}
	
	@PostMapping("/noticeinsert")
	public int insertNotice(@PathVariable String storeUrl ,@RequestBody NoticeEntity noticeEntity){
		return noticeService.insertNotice(noticeEntity, storeUrl);
	}
	
	@PutMapping("/noticeupdate")
	public int updateNotice(@PathVariable String storeUrl ,@RequestBody NoticeEntity noticeEntity){
		return noticeService.updateNotice(noticeEntity, storeUrl);
	}
	
	@DeleteMapping("/noticedelete/{noticeId}")
	public int deleteNotice(@PathVariable int noticeId){
		return noticeService.deleteNotice(noticeId);
	}
	
}
