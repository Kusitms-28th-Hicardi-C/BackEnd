package com.example.hicardi.domain.orders.service;

import com.example.hicardi.domain.orders.entity.Orders;
import com.example.hicardi.domain.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public Orders save(Orders orders){
        return orderRepository.save(orders);
    }
}
