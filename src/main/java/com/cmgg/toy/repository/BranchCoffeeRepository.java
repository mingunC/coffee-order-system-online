package com.cmgg.toy.repository;

import com.cmgg.toy.domain.BranchCoffee;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface BranchCoffeeRepository extends CrudRepository<BranchCoffee, Integer> {

    Optional<BranchCoffee> findByBranchIdAndCoffeeId(int branch, int coffeeId);
}
