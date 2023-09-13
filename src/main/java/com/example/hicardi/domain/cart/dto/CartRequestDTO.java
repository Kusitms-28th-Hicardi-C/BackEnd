package com.example.hicardi.domain.cart.dto;

import com.example.hicardi.domain.cart.entity.Cart;
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

    public Cart toEntity(){
        return Cart.builder()
//                .productId(this.productId)
                .quantity(this.quantity)
                .build();
    }
}
