package com.cmgg.toy.domain;

import java.time.ZonedDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "branches")
public class Branch {

    @Id
    private String branchId;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private ZonedDateTime openAt;

    @Column
    private ZonedDateTime closeAt;
}
