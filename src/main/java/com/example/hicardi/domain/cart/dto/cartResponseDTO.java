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
public class cartResponseDTO {
    public cartResponseDTO(Cart modifiedCart) {
    }
}
