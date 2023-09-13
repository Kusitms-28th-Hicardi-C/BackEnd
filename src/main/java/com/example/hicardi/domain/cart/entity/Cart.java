package com.example.hicardi.domain.cart.entity;

import com.example.hicardi.domain.cart.dto.CartRequestDTO;
import com.example.hicardi.domain.product.entity.Product;
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
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "quantity")
    private int quantity; //수량

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public void updateQuantity(int updateQuantity) {
        setQuantity(updateQuantity);
    }
}