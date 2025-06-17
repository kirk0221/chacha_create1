package com.chacha.create.model.entity.order;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {
	private Integer reviewId;
    private Integer orderDetailId;
    private Date reviewDate;
    private String reviewText;
}