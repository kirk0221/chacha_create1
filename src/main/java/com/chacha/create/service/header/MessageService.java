package com.chacha.create.service.header;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.chat.MessageDTO;
import com.chacha.create.common.entity.chat.ChatroomEntity;
import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.mapper.chat.ChatroomMapper;
import com.chacha.create.common.mapper.chat.MessageMapper;

@Service
public class MessageService {

	private MessageMapper messageMapper;
	private ChatroomMapper chatroomMapper;
	
	@Autowired
	public MessageService(MessageMapper messageMapper, ChatroomMapper chatroomMapper) {
		this.messageMapper = messageMapper;
		this.chatroomMapper = chatroomMapper;
	}
	
	// 스토어에서 채팅을 열었을 때
	public int makeChattingInStore(MemberEntity memberEntity, String url) {
		int result = 0;
		MessageDTO checkmessageDTO = null;
		
		// url과 memberid로 DTO를 만들어 채팅방이 있는지 확인
		MessageDTO messageDTO = MessageDTO.builder()
				.storeUrl(url)
				.memberId(memberEntity.getMemberId())
				.build();
		
		checkmessageDTO = messageMapper.selectForGetChatRoomIdByStoreURl(messageDTO);
		
		// 만약 없다면 채팅방을 만들고 채팅방 번호를 넣어줌
		if(checkmessageDTO == null) {
			result = messageMapper.insertChatroom(messageDTO);
			checkmessageDTO = messageMapper.selectForGetChatRoomIdByStoreURl(messageDTO);
		}
		// 이후 채팅을 넣어줌
		result = messageMapper.insertChatting(messageDTO);
		return result;
	}
	
	// 메시지 칸에서 열었을 때
	public int makeChattingInMyPage(MessageDTO messageDTO) {
		int result = 0;
		// messageDTO로 채팅방 id까지 받아 올 예정임
		result = messageMapper.insertChatting(messageDTO);
		return result;
	}
	
	// 로그인한 회원이 가지고있는 모든 채팅방을 확인
	public List<ChatroomEntity> getMembersAllChatroom(MemberEntity memberEntity){
		List<ChatroomEntity> chatroomEntities = null;
		chatroomEntities = chatroomMapper.selectByMemberId(memberEntity.getMemberId());
		return chatroomEntities;
	}
	
	// 회원정보와 스토어 url을 통해 주고받은 메시지를 전부 조회
	public List<MessageDTO> getMemberStoreAllMessage(MemberEntity memberEntity, String url){
		List<MessageDTO> messageDTOs = null;
		
		MessageDTO messageDTO = MessageDTO.builder()
				.storeUrl(url)
				.memberId(memberEntity.getMemberId())
				.build();
		
		messageDTOs = messageMapper.selectForMemberWithStoreURlAllMessage(messageDTO);
		
		return messageDTOs;
	}
	
	// 회원정보와 채팅방 id를 통해 주고받은 메시지를 전부 조회
	public List<MessageDTO> getMemberStoreAllMessage(MemberEntity memberEntity, int chatroomId){
		List<MessageDTO> messageDTOs = null;
		
		MessageDTO messageDTO = MessageDTO.builder()
				.chatroomId(chatroomId)
				.memberId(memberEntity.getMemberId())
				.build();
		
		messageDTOs = messageMapper.selectForMemberWithStoreAllMessage(messageDTO);
		
		return messageDTOs;
	}
	
}
