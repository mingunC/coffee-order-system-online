package com.cmgg.toy.service;

import com.cmgg.toy.domain.CreateOrder;
import com.cmgg.toy.domain.Order;
import com.cmgg.toy.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void newOrder(CreateOrder createOrder) {
        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);
    }
}
