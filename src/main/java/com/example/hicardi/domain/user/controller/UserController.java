package com.example.hicardi.domain.user.controller;

import com.example.hicardi.domain.user.dto.LoginRequestDTO;
import com.example.hicardi.domain.user.dto.LoginResponseDTO;
import com.example.hicardi.domain.user.dto.SignUpRequestDTO;
import com.example.hicardi.domain.user.entity.User;
import com.example.hicardi.domain.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Slf4j
@SessionAttributes("user")
public class UserController {

    private final UserService userService;

    //회원가입
    @CrossOrigin
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUpUser(@Validated @RequestBody SignUpRequestDTO dto
    ) {
        log.info("/user/sign-up POST! --{}", dto);

        try {
            boolean join = userService.signUp(dto);
            return ResponseEntity.ok().body(join);
        } catch (Exception e) {
            log.warn("기타 예외가 발생했습니다");
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    //아이디&사업자번호 중복확인
    @CrossOrigin
    @GetMapping("/check-duplicate")
    public ResponseEntity<?> check(String type,String keyword) {
        log.info("/user/check-business-number GET! --{} --{}", type, keyword);

        if(keyword.trim().equals("")){
            return ResponseEntity.badRequest().body(keyword+"가 없습니다!");
        }

        boolean resultFlag = userService.isDuplicate(type,keyword);
        log.info("{} 중복인가요? - {}", keyword, resultFlag);

        return ResponseEntity.ok().body(resultFlag);
    }

    //로그인
    @CrossOrigin
    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(
            @Validated @RequestBody LoginRequestDTO dto, HttpServletRequest request
    ){
        try{
            System.out.println("로그인 시 dto : " +dto);
            LoginResponseDTO responseDTO = userService.authenticate(dto);
            //세션 처리
            userService.handleSession(request.getSession(),dto.getLoginId());
            return ResponseEntity.ok().body(responseDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
