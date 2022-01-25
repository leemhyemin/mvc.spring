package com.spring.mvc.User;

import com.spring.mvc.member.domain.Auth;
import lombok.*;

import java.sql.Timestamp;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class UserInfo {
    
    private String userId; //아이디
    private String userPw; //비밀번호
    private String userEmail; //이메일
    private String userName; //이름
    private String userGender; //성별 M, F
    private int birthday; //생년월일
    private Timestamp regDate; //가입날짜
    private Auth auth; //권한 (관리자, 일반)
}
