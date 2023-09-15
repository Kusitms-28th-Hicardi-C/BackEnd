package com.example.hicardi.domain.cart.dto;

import com.example.hicardi.domain.cart.entity.Cart;
import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.domain.user.entity.User;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class CartRequestDTO {
    private Long productId;//제품 번호
    private int quantity; //개수

    public Cart toEntity(User user,Product product){
        return Cart.builder()
                .product(product)
                .quantity(this.quantity)
                .user(user)
                .build();
    }
}
