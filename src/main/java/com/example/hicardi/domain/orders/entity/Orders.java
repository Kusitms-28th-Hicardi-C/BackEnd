package com.example.hicardi.domain.orders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="orders")
@EntityListeners(AuditingEntityListener.class)
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;


}
