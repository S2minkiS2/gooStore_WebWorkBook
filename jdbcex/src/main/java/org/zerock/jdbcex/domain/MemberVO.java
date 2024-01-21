package org.zerock.jdbcex.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class MemberVO {

    private int memberNo;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberPhone;
    private LocalDate joinDate;
    private boolean memberShip;

}


