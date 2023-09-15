package com.example.hicardi.domain.blog.dto;

import com.example.hicardi.domain.blog.entity.Blog;
import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogListResponseDTO {
    private Long blogId;
    private String title;
    private String subTitle;
    private String content;
    private String eta; //읽는데 걸리는 시간
    private String category;
    private LocalDate createdAt;

    public BlogListResponseDTO(Blog blog) {
        this.blogId = blog.getBlogId();
        this.title = blog.getTitle();
        this.subTitle = blog.getSubTitle();
        this.content = blog.getContent();
        this.eta=blog.getEta();
        this.category = blog.getCategory();
        this.createdAt = blog.getCreatedAt();
    }
}
