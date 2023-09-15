package com.example.hicardi.domain.cart.service;


import com.example.hicardi.domain.cart.dto.*;
import com.example.hicardi.domain.cart.entity.Cart;
import com.example.hicardi.domain.cart.repository.CartRepository;
import com.example.hicardi.domain.product.Repository.ProductRepository;
import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.domain.user.entity.User;
import com.example.hicardi.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public cartResponseDTO cartAdd(Long memberId, CartRequestDTO dto) {
        User user = userRepository.findByMemberId(memberId);
        Product product=productRepository.findByProductId(dto.getProductId());

        boolean isExist = cartRepository.existsByUserMemberIdAndProductProductId(memberId, dto.getProductId()); //유저가 저장한 제품이 장바구니에 있는가?

        Cart modifiedCart;

        if (isExist == false) {//장바구니에 없다면 저장
            modifiedCart = cartRepository.save(dto.toEntity(user,product));
        } else {//담으려는 상품이 장바구니에 이미 존재한다면 수량만 증가
            Cart cart = cartRepository.findByProductProductIdAndUserMemberId(dto.getProductId(),memberId);
            int updateQuantity = cart.getQuantity() + dto.getQuantity();
            cart.updateQuantity(updateQuantity);
            modifiedCart = cartRepository.save(cart);
        }
        return new cartResponseDTO(modifiedCart);
    }


    public boolean deleteCart(Long cartId,Long memberId) {
//        User user = userRepository.findByLoginId(loginId);
        cartRepository.deleteByCartIdAndUserMemberId(cartId,memberId);
        return true;
    }

    //존재하는 장바구니 번호인가?
    public boolean isCartExists(Long cartId) {
        return cartRepository.existsByCartId(cartId);
    }

    //유저의 카트 전체 정보 + 총합
//    public CartListResponseDTO getAllUserCart(Long memberId) {
//
//        List<Cart> userCartList = cartRepository.findByUserMemberId(memberId);
//        int totalPrice = countTotalPrice(userCartList);
//
//        List<CartListDataResponseDTO> list = userCartList.stream()
//        .map(cart->new CartListDataResponseDTO(cart)).collect(Collectors.toList());
//
//        return new CartListResponseDTO(list,totalPrice);
//
//    }

    // 장바구니에 들어있는 상품들의 총 가격을 계산
    public int countTotalPrice(List<Cart> userCartList){
        int totalPrice=0;
        for (Cart cart:userCartList) {
            totalPrice+=cart.getQuantity() * Integer.parseInt(cart.getProduct().getPrice());
        }
        return totalPrice;
    }

    public cartResponseDTO modifyCart(CartModifyRequesDTO dto) {
        Cart cart = cartRepository.findByCartId(dto.getCartId());
        System.out.println("before modify cart : "+cart.getQuantity());

        cart.updateQuantity(dto.getQuantity());
        System.out.println("after modify cart : "+cart.getQuantity());

        Cart modifiedCart = cartRepository.save(cart);
        return new cartResponseDTO(modifiedCart.getQuantity());
    }
}
