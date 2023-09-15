package com.example.hicardi.domain.blog.repository;

import com.example.hicardi.domain.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {
    List<Blog> findByTitleContaining(String category);

    List<Blog> findByCategoryContaining(String category);

    @Query("SELECT b FROM Blog b WHERE b.title LIKE %:keyword% OR b.content LIKE %:keyword%")
    List<Blog> findByKeywordInTitleOrContent(@Param("keyword") String keyword);

}
