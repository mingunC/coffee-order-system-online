package com.cmgg.toy.domain;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "orders")
public class Order {
    @Id
    private int orderId;

    @Column
    private int customerId;

    @Column
    private Timestamp orderedAt;

    @MappedCollection(idColumn = "order_item_id", keyColumn = "order_id")
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(int customerId, Timestamp orderedAt, List<OrderItem> orderItems) {
        this.customerId = customerId;
        this.orderedAt = orderedAt;
        this.orderItems = orderItems;
    }

    public static Order newORder(CreateOrder createOrder) {
        List<OrderItem> items = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : createOrder.getQuantityByCoffee().entrySet()) {
            items.add(new OrderItem(entry.getKey(), entry.getValue()));
        }
        return new Order(createOrder.getCustomerId(), items);
    }
}
