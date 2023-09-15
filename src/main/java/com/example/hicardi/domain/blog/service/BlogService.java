package com.example.hicardi.domain.blog.service;

import com.example.hicardi.domain.blog.dto.BlogListResponseDTO;
import com.example.hicardi.domain.blog.entity.Blog;
import com.example.hicardi.domain.blog.repository.BlogRepository;
import com.example.hicardi.domain.search.BlogSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BlogService {

    private final BlogRepository blogRepository;

    //전체 조회
    public List<BlogListResponseDTO> findAll(BlogSearch search) {
        //카테고리 검색
        if(search.getCategory()!=""&&search.getKeyword()==""){
            return blogRepository.findByCategoryContaining(search.getCategory()).stream()
                    .map(blog -> new BlogListResponseDTO(blog)).collect(Collectors.toList());
        }
        //검색어로 검색
        else if(search.getCategory()==""&&search.getKeyword()!=""){
            return blogRepository.findByKeywordInTitleOrContent(search.getKeyword()).stream()
                    .map(blog -> new BlogListResponseDTO(blog)).collect(Collectors.toList());
        }
        //키워드, 검색어 없이 전체 조회 할 시
        return blogRepository.findAll().stream()
                .map(blog -> new BlogListResponseDTO(blog)).collect(Collectors.toList());
    }

    public BlogListResponseDTO findById(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글 존재x. id=" + id));
        return new BlogListResponseDTO(blog);
    }
}
