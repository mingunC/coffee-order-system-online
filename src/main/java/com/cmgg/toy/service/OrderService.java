package com.cmgg.toy.service;

import com.cmgg.toy.domain.BranchCoffee;
import com.cmgg.toy.domain.CreateOrder;
import com.cmgg.toy.domain.Order;
import com.cmgg.toy.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BranchService branchService;

    public OrderService(OrderRepository orderRepository, BranchService branchService) {
        this.orderRepository = orderRepository;
        this.branchService = branchService;
    }

    public void newOrder(CreateOrder createOrder) {
        for(Map.Entry<Integer, Integer> entry : createOrder.getQuantityByCoffee().entrySet()) {
            Integer coffeeId = entry.getKey();
            Integer buyQuantity = entry.getValue();

            BranchCoffee branchCoffee = branchService.getBranchCoffee(
                    createOrder.getBranchId(),
                    coffeeId);
            int stockQuantity = branchCoffee.getStockQuantity();

            if(buyQuantity > stockQuantity) {
                throw new RuntimeException("Not enough stock for coffee");
            }

            branchCoffee.adjustStockQuantity(buyQuantity);
            branchCoffee.add(branchCoffee);
        }

        Order entity = Order.newOrder(createOrder);
        orderRepository.save(entity);
    }
}
