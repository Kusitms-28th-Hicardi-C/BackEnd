package com.example.hicardi.domain.user.service;

import com.example.hicardi.domain.user.dto.SignUpRequestDTO;
import com.example.hicardi.domain.user.entity.User;
import com.example.hicardi.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;


    public boolean signUp(SignUpRequestDTO dto) {

//        dto.setPassword(encoder.encode(dto.getPassword()));

        System.out.println("password : "+dto.getPassword());

        User user = dto.toEntity();
//
        User saveUser = userRepository.save(user);

//        log.info("회원가입 정상 수행! - saved user - {}",saveUser);

        if(saveUser!=null){//리턴값이 비어있지않다면 회원가입성공
            return true;
        }else{ //비어있다면 회원가입 실패
            return false;
        }

    }
}
