package com.cmgg.toy.domain;

import java.math.BigDecimal;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "coffee")
public class Coffee {

    @Id
    private String coffeeId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;
}
