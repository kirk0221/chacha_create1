package com.chacha.create.model.entity.store;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity {
    private Integer questionId;
    private Integer memberId;
    private Date questionDate;
    private String questionTitle;
    private String questionText;
}