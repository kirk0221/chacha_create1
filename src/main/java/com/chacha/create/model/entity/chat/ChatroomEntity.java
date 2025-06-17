package com.chacha.create.model.entity.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatroomEntity {
	private Integer chatroomId;
	private Integer storeId;
	private Integer memberId;
}
