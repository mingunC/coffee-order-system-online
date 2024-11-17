package com.cmgg.toy.repository;

import com.cmgg.toy.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {


}
