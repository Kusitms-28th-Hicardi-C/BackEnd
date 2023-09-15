package com.example.hicardi.domain.product.service;

import com.example.hicardi.domain.product.Repository.ProductRepository;
import com.example.hicardi.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public Product findById(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + productId));
    }
    public List<Product> findByAll(){
        return productRepository.findAll();
    }

}
