package com.cmgg.toy.service;

import com.cmgg.toy.domain.BranchCoffee;
import com.cmgg.toy.domain.CreateOrder;
import com.cmgg.toy.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    BranchService branchService;

    @InjectMocks
    OrderService orderService;

    @Test
    @DisplayName("When buy Quantity excess stock Quantity, it is available")
    public void stockQuantityTest_success() {
        //given
        int buyQuantity = 5;
        int stockQuantity = 50;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, buyQuantity);
        CreateOrder createOrder = CreateOrder.builder()
                .branchId(1)
                .customerId(1)
                .quantityByCoffee(map)
                .build();
        BranchCoffee stock = BranchCoffee.builder()
                .stockQuantity(stockQuantity)
                .build();
        when(branchService.getBranchCoffee(1,1)).thenReturn(stock);
        //when
        assertThrows(RuntimeException.class, () -> {
            orderService.newOrder(createOrder);
        });


        //then
        assertThat(stock.getStockQuantity()).isEqualTo(stockQuantity-buyQuantity);
    }

}