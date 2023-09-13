package com.example.hicardi.domain.cart.service;

import com.example.hicardi.domain.cart.dto.CartRequestDTO;
import com.example.hicardi.domain.cart.entity.Cart;
import com.example.hicardi.domain.cart.repository.CartRepository;
import com.example.hicardi.domain.user.repository.UserRepository;
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
    private final UserRepository userRepository;

    public void addCart(String userId, CartRequestDTO dto) {
        boolean isExist = cartRepository.existsUserIdAndProductId(userId, dto.getProductId());
        if(isExist==false){
//            cartRepository.save(dto.toEntity(userId));
        }

        Cart cart = cartRepository.findByUserId(userId);

        //장바구니에 제품이 아예 없다면
        if(cart==null){
            cart = dto.toEntity();
            cartRepository.save(cart);
        }

        // 담으려는 상품이 장바구니에 존재하지 않는다면 카트상품 생성 후 추가


        //담으려는 상품이 장바구니에 이미 존재한다면 수량만 증가




    }
}
