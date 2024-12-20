package com.cmgg.toy.controller;

import com.cmgg.toy.domain.CreateOrder;
import com.cmgg.toy.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/orders")
    public Response<Void> newOrder(
            @RequestBody NewOrderRequest request
    ) {
        orderService.newOrder(CreateOrder.builder()
                .customerId(request.getCustomerId())
                .branchId(request.getBranchId())
                .quantityByCoffee(request.getCoffees())
                .build());
        return Response.success(null);
    }
}
