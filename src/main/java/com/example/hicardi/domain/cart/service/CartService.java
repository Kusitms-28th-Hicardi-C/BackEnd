package com.example.hicardi.domain.cart.service;

import com.example.hicardi.domain.cart.dto.CartRequestDTO;
import com.example.hicardi.domain.cart.entity.Cart;
import com.example.hicardi.domain.cart.repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CartService {
    private final CartRepository cartRepository;
}
