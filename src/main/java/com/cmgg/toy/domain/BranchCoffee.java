package com.cmgg.toy.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Getter
@Table(name = "branch_Coffees")
@Builder
public class BranchCoffee {

    @Id
    private int branchCoffeeId;

    @Column
    private int branchId;

    @Column
    private int coffeeId;

    @Column
    private int stockQuantity;

    public void adjustStockQuantity(int  buyQuantity) {
        if(stockQuantity < buyQuantity) {
            throw new RuntimeException("Order quantity never exceeds stock quantity");
        }
        this.stockQuantity = this.stockQuantity - buyQuantity;
    }
}
