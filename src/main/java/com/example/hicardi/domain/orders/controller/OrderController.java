package com.example.hicardi.domain.orders.controller;

import com.example.hicardi.domain.orders.dto.OrderDto;
import com.example.hicardi.domain.orders.entity.Orders;
import com.example.hicardi.domain.orders.service.OrderService;
import com.example.hicardi.domain.user.entity.User;
import com.example.hicardi.domain.user.service.UserService;
import com.example.hicardi.global.exception.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final UserService userService;

    @PostMapping("/save")
    public BaseResponse<OrderDto.Response> save(@RequestBody OrderDto.Request orderDto)throws Exception{

        User user = userService.findUserByMemberId(orderDto.getMemberId());
        Orders result = orderService.save(orderDto.toEntity(user));

        return BaseResponse.onSuccess(new OrderDto.Response(result,user));
    }
}
