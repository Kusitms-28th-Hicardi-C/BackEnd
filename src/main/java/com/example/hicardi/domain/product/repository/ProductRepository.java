package com.example.hicardi.domain.product.repository;

import com.example.hicardi.domain.Faq.entity.Faq;
import com.example.hicardi.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByProductId(Long productId);
    @Query(value = "Select * From product where description Like :#{#keyword} or name Like :#{#keyword} ", nativeQuery = true)
    List<Product> findProductByDescriptionLikeAndNameLike(String keyword);
}
