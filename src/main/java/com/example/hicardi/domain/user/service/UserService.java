package com.example.hicardi.domain.user.service;

import com.example.hicardi.domain.user.dto.LoginRequestDTO;
import com.example.hicardi.domain.user.dto.LoginResponseDTO;
import com.example.hicardi.domain.user.dto.SignUpRequestDTO;
import com.example.hicardi.domain.user.entity.User;
import com.example.hicardi.domain.user.repository.UserRepository;
import com.example.hicardi.global.util.LoginUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //사업자번호 중복 확인
    public boolean isDuplicate(String type,String keyword) {

        if(type.equals("loginId")){
            return userRepository.existsByLoginId(keyword);
        }else if(type.equals("businessNumber")){
            return userRepository.existsByBusinessNumber(keyword);
        }
        throw new RuntimeException("중복 확인할 목록을 바르게 입력해 주세요");
    }

    public LoginResponseDTO authenticate(final LoginRequestDTO dto) {

        User user = findUserByloginId(dto.getLoginId());

        String rawPassword = dto.getPassword();//사용자가 입력한 비번
        String dbPassword = user.getPassword();//db에 저장된 비번

        System.out.println("user rawPassword: "+rawPassword);
        System.out.println("user dbPassword : "+dbPassword);

        if(user==null){
            throw new RuntimeException("회원가입을 먼저 진행해주세요");
        }else {
            //패스워드를 검증
            if(rawPassword.equals(dbPassword)){
                log.info("{}님 로그인 성공!!", user.getName());
                return new LoginResponseDTO(user);
            }else{
                throw new RuntimeException("비밀번호가 틀렸습니다");
            }
        }
    }
    
    //세션 처리
    public void handleSession(HttpSession session, String loginId) {
        User user = findUserByloginId(loginId);

        session.setAttribute(LoginUtil.LOGIN_KEY,user.getMemberId());
        System.out.println("session : "+ session.getAttribute(LoginUtil.LOGIN_KEY));
        // 세션의 수명을 설정 -> 1시간
        session.setMaxInactiveInterval(60 * 60 * 24);
    }

    public User findUserByloginId(String loginId){
        return userRepository.findByLoginId(loginId);
    }
    public User findUserByMemberId(Long memberId){
        return userRepository.findByMemberId(memberId);
    }

    public List<User> findByAll(){return userRepository.findAll();}
}


