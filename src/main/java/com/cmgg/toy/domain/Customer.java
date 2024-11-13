package com.cmgg.toy.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table(name = "customers")
public class Customer {
    @Id
    private int customerId;

    @Column
    private String Name;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    public Customer(String name, String address, String phoneNumber) {
        this.Name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static Customer newCustomer(CreateCustomer customer) {
        return new Customer(customer.getName(), customer.getAddress(), customer.getPhoneNumber());
    }
}
