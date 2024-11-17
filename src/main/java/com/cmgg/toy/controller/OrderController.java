package com.cmgg.toy.controller;

import com.cmgg.toy.domain.CreateOrder;
import com.cmgg.toy.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/orders")
    public Response<Void> newOrder() {
        HashMap<Integer, Integer> orderMap = new HashMap<>();
        orderMap.put(1 ,5);
        orderMap.put(2 ,15);
        orderService.newOrder(CreateOrder.builder()
                .customerId(1)
                .quantityByCoffee(orderMap)
                .build());
        return Response.success(null);
    }
}
