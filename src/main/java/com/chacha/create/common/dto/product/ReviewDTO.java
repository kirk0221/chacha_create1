package com.chacha.create.common.dto.product;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    
	// ReviewEntity
	private Integer reviewId;
    private Integer orderDetailId;
    private Date reviewDate;
    private String reviewText;
    
    // MemberEntity
    private Integer memberId;
    private String memberName;
}
