package com.infosys.amex.RewardSystemApplication.repository;

import com.infosys.amex.RewardSystemApplication.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
