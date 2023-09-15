package com.example.hicardi.domain.product.controller;

import com.example.hicardi.domain.product.dto.ProductDto;
import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.domain.product.service.ProductService;
import com.example.hicardi.global.exception.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;
    @GetMapping("/list")
    public BaseResponse<List<ProductDto.Response>> postList(){
        List<Product> diaryList = productService.findByAll();
        List<ProductDto.Response> resultDto = diaryList.stream()
                .map(data-> modelMapper.map(data, ProductDto.Response.class))
                .collect(Collectors.toList());
        return BaseResponse.onSuccess(resultDto);
    }
}
