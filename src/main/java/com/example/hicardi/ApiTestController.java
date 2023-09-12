package com.example.hicardi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTestController {
    @GetMapping("/")
    public String test() {
        return "test good blue ";
    }

    
}
