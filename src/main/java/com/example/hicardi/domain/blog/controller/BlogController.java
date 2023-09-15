package com.example.hicardi.domain.blog.controller;

import com.example.hicardi.domain.search.BlogSearch;
import com.example.hicardi.domain.blog.dto.BlogListResponseDTO;
import com.example.hicardi.domain.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
@Slf4j
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/list")
    public ResponseEntity<?> blogMainPage(@Validated @RequestBody BlogSearch search) {
        List<BlogListResponseDTO> all = blogService.findAll(search);

        return ResponseEntity
                .ok()
                .body(all);
    }

    //상세 조회
    @GetMapping("/{blogId}")
    public ResponseEntity<?> blogDetail(@PathVariable("blogId") Long blogId
    ) {
        BlogListResponseDTO dto= blogService.findById(blogId);

        return ResponseEntity
                .ok()
                .body(dto);
    }

}
