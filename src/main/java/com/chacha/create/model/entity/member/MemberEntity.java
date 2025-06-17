package com.chacha.create.model.entity.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    private Integer memberId;
    private String memberEmail;
    private String memberName;
    private String memberPwd;
    private String memberPhone;
    private String memberRegi;
    private Date joinDate;
}