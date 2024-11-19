package com.cmgg.toy.controller;

import lombok.Getter;

import java.util.Map;

@Getter
public class NewOrderRequest {
    private final Integer customerId;
    private final Integer branchId;
    private final Map<Integer, Integer> coffees;

    public NewOrderRequest(Integer customerId, Integer branchId, Map<Integer, Integer> coffees) {
        this.customerId = customerId;
        this.branchId = branchId;
        this.coffees = coffees;
    }
}
