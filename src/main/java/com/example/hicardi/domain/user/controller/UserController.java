package com.example.hicardi.domain.user.controller;

import com.example.hicardi.domain.user.dto.SignUpRequestDTO;
import com.example.hicardi.domain.user.service.UserService;
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
public class UserController {

    private final UserService userService;

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

}
