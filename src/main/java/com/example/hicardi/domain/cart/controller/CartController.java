package com.example.hicardi.domain.cart.controller;

import com.example.hicardi.domain.cart.dto.CartRequestDTO;
import com.example.hicardi.domain.cart.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
@Slf4j
public class CartController {

    private final CartService cartService;

    //장바구니에 제품 추가

    //장바구니 전체 조회

    //장바구니 수정

    //장바구니에서 제품 삭제



}
