package com.cmgg.toy.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "order_items")
public class OrderItem {

    @Id
    private String orderItemId;

    @Column
    private int coffeeId;

    @Column
    private int orderId;

    @Column
    private int orderQuantity;

    public OrderItem(int coffeeId, int orderQuantity) {
        this.coffeeId = coffeeId;
        this.orderQuantity = orderQuantity;
    }
}
