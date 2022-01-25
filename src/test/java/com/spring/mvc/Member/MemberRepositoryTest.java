package com.spring.mvc.Member;

import com.spring.mvc.member.domain.Auth;
import com.spring.mvc.member.domain.Member;
import com.spring.mvc.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest //스프링컨테이너에서 객체를 주입받아 테스트

public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입에 성공해야한다.")
    void regTest() {

        Member member = new Member();
        member.setAccount("abc1234");

        //암호화작용
        /*member.setPassword("aaa1111");*/
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode("aaa1111");
        member.setPassword(encodePassword);


        member.setName("철수");
        member.setEmail("abc@naver.com");
        member.setAuth(Auth.COMMON);

        memberRepository.register(member);
    }

    @Test
    @DisplayName("아이디, 이메일 중복확인에 성공해야한다,")
    void dupleTest() {
        String inputId = "def1234";
        int result = memberRepository.isDuplicateId(inputId);
        assertEquals(1,result);

        String intputEmail = "abcdef@naver.com";
        int result2 = memberRepository.isDuplicateEmail(intputEmail);
        assertEquals(0,result2);
    }
}
