package com.example.hicardi.domain.orders.repository;

import com.example.hicardi.domain.orders.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
