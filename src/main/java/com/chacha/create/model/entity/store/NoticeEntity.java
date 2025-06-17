package com.chacha.create.model.entity.store;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NoticeEntity {
	private Integer noticeId;
	private Integer storeId;
	private Integer noticeCheck;
	private String noticeTitle;
	private String noticeText;
	private Date noticeDate;


}
