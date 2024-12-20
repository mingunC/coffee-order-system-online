package com.cmgg.toy.service;

import com.cmgg.toy.domain.BranchCoffee;
import com.cmgg.toy.repository.BranchCoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    private final BranchCoffeeRepository branchCoffeeRepository;

    public BranchService(BranchCoffeeRepository branchCoffeeRepository) {
        this.branchCoffeeRepository = branchCoffeeRepository;
    }

    public BranchCoffee getBranchCoffee(int branchId, int coffeeId) {
        Optional<BranchCoffee> branchCoffeeOptional = branchCoffeeRepository.findByBranchIdAndCoffeeId(branchId, coffeeId);
        if(branchCoffeeOptional.isEmpty()) {
            throw new RuntimeException("Not exist branch coffee");
        }

        return branchCoffeeOptional.get();
    }
    public void saveAll(List<BranchCoffee> branchCoffees) {
        branchCoffeeRepository.saveAll(branchCoffees);
    }
}
