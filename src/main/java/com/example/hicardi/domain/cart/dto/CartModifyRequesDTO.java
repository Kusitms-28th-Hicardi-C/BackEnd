package com.example.hicardi.domain.cart.dto;

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
public class CartModifyRequesDTO {
    public Long cartId;
    public int quantity;
}
