package com.example.hicardi.user;

import com.example.hicardi.domain.user.dto.GENDER;
import com.example.hicardi.domain.user.entity.User;
import com.example.hicardi.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static com.example.hicardi.domain.user.dto.BUSINESS.PERSONAL;
import static com.example.hicardi.domain.user.dto.GENDER.F;
import static com.example.hicardi.domain.user.dto.MEMBERSHIP.BUSINESSMEMEBER;
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveUserTest(){
        User saveUser = User.builder()
                .membershipVerification(BUSINESSMEMEBER)
                .businessClassification(PERSONAL)
                .loginId("kusitms1")
                .password("kusitms1234")
                .name("큐시즘")
                .businessName("상호명")
                .businessNumber("1234567890")
                .landLine("021234567")
                .address("서울 강남구 도곡동 411-19 지앤지빌딩")
                .phoneNumber("021234567")
                .email("kusitms@google.com")
                .gender(F)
//                .birthDate(2001-01-01)
                .ykiho("12345678")
                .build();

        userRepository.save(saveUser);

    }
}
