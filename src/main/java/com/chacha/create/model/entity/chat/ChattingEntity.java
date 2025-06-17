package com.chacha.create.model.entity.chat;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChattingEntity {
	private Integer chattingId;
	private Integer chatroomId;
	private String chattingText;
	private Date chattingDate;

}
