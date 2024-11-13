package com.cmgg.toy.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "branchCoffees")
public class BranchCoffee {

    @Id
    private String branchCoffeeId;

    @Column
    private String storeId;

    @Column
    private String coffeeId;

    @Column
    private String stockQuantity;
}
