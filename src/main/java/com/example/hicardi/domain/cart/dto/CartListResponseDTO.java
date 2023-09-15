package com.example.hicardi.domain.cart.dto;

import com.example.hicardi.domain.cart.entity.Cart;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class CartListResponseDTO {

    private List<CartListDataResponseDTO> carts; //카드 정보들

    private int totalPrice; //총 금액

    public CartListResponseDTO(List<CartListDataResponseDTO> list, int totalPrice){
        this.carts = list;
        this.totalPrice=totalPrice;
    }

}
