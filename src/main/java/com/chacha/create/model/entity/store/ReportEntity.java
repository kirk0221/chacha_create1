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
public class ReportEntity {
    private Integer reportId;
    private Integer memberId;
    private Integer sellerId;
    private Date reportDate;
    private String reportTitle;
    private String reportText;
}