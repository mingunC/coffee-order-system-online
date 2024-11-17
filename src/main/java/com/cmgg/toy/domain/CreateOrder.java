package com.cmgg.toy.domain;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateOrder {
    private int customerId;
    private int branchId;
    private Map<Integer, Integer> quantityByCoffee; // [iced americano, 3
}
