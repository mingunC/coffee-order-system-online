package com.cmgg.toy.repository;

import com.cmgg.toy.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
