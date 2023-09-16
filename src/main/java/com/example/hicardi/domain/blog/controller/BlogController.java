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

    //전체조회
    @GetMapping("/list")
    public ResponseEntity<?> blogMainPage() {
        List<BlogListResponseDTO> all = blogService.findAll();

        return ResponseEntity
                .ok()
                .body(all);
    }

    //키워드 검색
    @GetMapping("/keyword")
    public ResponseEntity<?> blogSearchWithKeyword(@Validated @RequestParam String keyword) {
        List<BlogListResponseDTO> searchAll = blogService.findAllByKeyword(keyword);

        return ResponseEntity
                .ok()
                .body(searchAll);
    }

    //카테고리 검색
    @GetMapping("/category")
    public ResponseEntity<?> blogSearchWithCategory(@Validated @RequestParam String category) {
        List<BlogListResponseDTO> searchAll = blogService.findAllByCategory(category);

        return ResponseEntity
                .ok()
                .body(searchAll);
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
