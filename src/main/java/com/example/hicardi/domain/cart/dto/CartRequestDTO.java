package com.example.hicardi.domain.cart.dto;

import com.example.hicardi.domain.cart.entity.Cart;
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
    private int productId;//제품 번호
    private Long quantity; //개수
    private User user;

    public Cart toEntity(User user){
        return Cart.builder()
//                .productId(this.productId)
                .quantity(this.quantity)
                .user(user)
                .build();
    }
}
