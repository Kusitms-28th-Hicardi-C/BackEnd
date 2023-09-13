package com.example.hicardi.domain.cart.entity;

import com.example.hicardi.domain.cart.dto.CartRequestDTO;
import com.example.hicardi.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_Id")
    private Long cartId;

    @Column(name = "quantity")
    private Long quantity; //수량

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void updateCart(CartRequestDTO dto) {
        setQuantity(dto.getQuantity());
    }
}