package com.example.hicardi.domain.cart.dto;

import com.example.hicardi.domain.cart.entity.Cart;
import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartListDataResponseDTO {

    private Long cartId;
    private int quantity; //수량
    private String productName;
    private String price;

    public CartListDataResponseDTO(Cart cart) {
        this.cartId=cart.getCartId();
        this.quantity=cart.getQuantity();
        this.productName=cart.getProduct().getName();
        this.price=cart.getProduct().getPrice();
    }
}
