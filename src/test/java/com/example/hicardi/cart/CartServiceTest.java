package com.example.hicardi.cart;

import com.example.hicardi.domain.cart.entity.Cart;
import com.example.hicardi.domain.cart.repository.CartRepository;
import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.domain.user.entity.User;
import com.example.hicardi.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void saveCartTest(){

        boolean b = cartRepository.existsByUserMemberIdAndProductProductId(1L, 1);
        System.out.println("b : "+b);

    }

    @Test
    public void deleteCartTest(){

        boolean b1 = cartRepository.existsByCartIdAndUserMemberId(6L, 1L);
        System.out.println("b1" + b1);
        if(b1==true){

//            Cart cart = cartRepository.findByCartIdAndUserMemberId(6L, 1L);
//            cart.setUser(null);
//            cart.setProduct(null);
//
//            boolean b2 = cartRepository.deleteByCartIdAndUserMemberId(6L, 1L);
//            System.out.println("b : "+b2);

        }


    }

}
