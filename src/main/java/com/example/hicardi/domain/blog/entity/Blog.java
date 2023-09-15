package com.example.hicardi.domain.blog.entity;

import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long blogId;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "sub_title",nullable = false)
    private String subTitle;

    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "eta",nullable = false)
    private String eta; //읽는데 걸리는 시간

    @Column(name = "category",nullable = false)
    private String category;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;
}
