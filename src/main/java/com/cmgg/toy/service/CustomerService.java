package com.cmgg.toy.service;

import com.cmgg.toy.domain.CreateCustomer;
import com.cmgg.toy.domain.Customer;
import com.cmgg.toy.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer newCustomer(CreateCustomer customer) {
        Customer entity = Customer.newCustomer(customer);
        return customerRepository.save(entity);
    }


}
