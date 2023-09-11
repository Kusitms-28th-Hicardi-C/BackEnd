package com.example.hicardi.domain.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    //회원가입페이지
    @GetMapping("/sign-up")
    public String signUp() {
        log.info("회원가입페이지");
        return "account/sign-up";
    }

}
