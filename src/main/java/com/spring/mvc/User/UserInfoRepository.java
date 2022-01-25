package com.spring.mvc.User;

import com.spring.mvc.score.Score;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserInfoRepository {

    //회원가입
    boolean info(UserInfo userInfo);

    //아이디중복
    int IDisDuplicate(String inputKeyword);

    //이메일중복
    int EmailisDuplicate(String inputKeyword);

    //삭제
    boolean remove(String inputKeyword);
}
