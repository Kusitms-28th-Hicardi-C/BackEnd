package com.example.hicardi.domain.cart.service;


import com.example.hicardi.domain.cart.dto.CartRequestDTO;
import com.example.hicardi.domain.cart.dto.cartResponseDTO;
import com.example.hicardi.domain.cart.entity.Cart;
import com.example.hicardi.domain.cart.repository.CartRepository;
import com.example.hicardi.domain.user.entity.User;
import com.example.hicardi.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    public cartResponseDTO cartAdd(String userId, CartRequestDTO dto) {
        User user = userRepository.findByLoginId(userId);
        Long memberId = user.getMemberId();

        boolean isExist = cartRepository.existsByUserMemberIdAndProductProductId(memberId, dto.getProductId()); //유저가 저장한 제품이 장바구니에 있는가?

        Cart modifiedCart;

        if (isExist == false) {//장바구니에 없다면 저장
            modifiedCart = cartRepository.save(dto.toEntity(user));
        } else {//담으려는 상품이 장바구니에 이미 존재한다면 수량만 증가
            Cart cart = cartRepository.findByUserMemberId(memberId);
            int updateQuantity = cart.getQuantity() + dto.getQuantity();
            cart.updateQuantity(updateQuantity);
            modifiedCart = cartRepository.save(cart);
        }
        return new cartResponseDTO(modifiedCart);
    }


    public boolean deleteCart(Long cartId,String loginId) {
        User user = userRepository.findByLoginId(loginId);
        cartRepository.deleteByCartIdAndUserMemberId(cartId,user.getMemberId());
        return true;
    }
}
