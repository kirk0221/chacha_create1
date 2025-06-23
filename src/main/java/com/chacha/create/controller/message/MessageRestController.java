package com.chacha.create.controller.message;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.chat.ChatroomEntity;
import com.chacha.create.common.entity.chat.MessageDTO;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.service.message.MessageService;

@RestController
@RequestMapping("/{storeUrl}/message")
public class MessageRestController {
	
	@Autowired
	MessageService messageService;
	
	String mainpage = "main";
	
	@GetMapping(value = "/getMessageAll")
	public List<MessageDTO> getAllMessage(@PathVariable String storeUrl, @RequestParam(value = "chatroomId", required = false) int chatroomId, HttpSession session) {
		MemberEntity memberEntity =  (MemberEntity) session.getAttribute("loginMember");
		if(!(mainpage.equals(storeUrl))) {
			return messageService.getMemberStoreAllMessage(memberEntity, storeUrl);
		}else {
			
			return messageService.getMemberStoreAllMessage(memberEntity, chatroomId);
		}
	}
	
	@GetMapping(value = "/chatroomList")
	public List<ChatroomEntity> getChatroomlist(HttpSession session) {
		MemberEntity memberEntity =  (MemberEntity) session.getAttribute("loginMember");
		return messageService.getMembersAllChatroom(memberEntity);
	}
	
	@PostMapping(value = "/makeChatting", produces = MediaType.APPLICATION_JSON_VALUE)
	public int makeChatting(@PathVariable String storeUrl, @RequestBody MessageDTO messageDTO, HttpSession session) {
		int result = 0;
		MemberEntity memberEntity =  (MemberEntity) session.getAttribute("loginMember");
		
		if(!(mainpage.equals(storeUrl))) {
			messageService.makeChattingInStore(memberEntity, storeUrl);
		}else {
			messageService.makeChattingInMyPage(messageDTO);
		}
		
		
		return result;
	}
	
}
