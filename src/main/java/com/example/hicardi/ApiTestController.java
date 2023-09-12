package com.example.hicardi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTestController {
    @RequestMapping("/")
    public String test() {
        return "test good blue ";
    }

    
}
