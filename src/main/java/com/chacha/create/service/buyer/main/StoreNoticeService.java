package com.chacha.create.service.buyer.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.mapper.store.NoticeMapper;

@Service
public class StoreNoticeService {

	@Autowired
	NoticeMapper noticeMapper;
	
	public List<Map<String, Object>> noticeList(String storeUrl){
		return noticeMapper.noticeList(storeUrl);
	}
	
	public List<Map<String, Object>> noticeDetailList(String storeUrl, int noticeId){ 
		return noticeMapper.noticeDetailList(storeUrl, noticeId);
	}
}
