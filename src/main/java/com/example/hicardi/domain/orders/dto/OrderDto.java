package com.example.hicardi.domain.orders.dto;

import com.example.hicardi.domain.orders.entity.Orders;
import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.domain.user.entity.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Member;
import java.time.LocalDateTime;
@Builder
public class OrderDto {
    @NoArgsConstructor
    @Data
    public static class Request{

        private String name;
        private String address;
        private String number;

        private String email;

        private String price;

        private String quantity;

        private String category;

        private Long memberId;

        public Orders toEntity(User user) {
            return Orders.builder()

                    .name(name)
                    .address(address)
                    .number(number)
                    .email(email)
                    .price(price)
                    .quantity(quantity)
                    .category(category)
                    .user(user)
                    .build();
        }

        public Request(Orders orders) {
            this.name=orders.getName();
            this.address=orders.getAddress();
            this.number=orders.getNumber();
            this.email=orders.getEmail();
            this.price=orders.getPrice();
            this.quantity=orders.getQuantity();
            this.memberId=getMemberId();
        }
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Response{

        private Long orderId;
        private String name;
        private String address;
        private String number;

        private String email;

        private String price;

        private String quantity;

        private String category;

        private String memberId;

        @Builder
        public Response(Orders orders, User user) {
            this.orderId= orders.getOrderId();
            this.name=orders.getName();
            this.address=orders.getAddress();
            this.number=orders.getNumber();
            this.email=orders.getEmail();
            this.price=orders.getPrice();
            this.quantity=orders.getQuantity();
            this.category=orders.getCategory();
            this.memberId=user.getName();
        }
    }
}
