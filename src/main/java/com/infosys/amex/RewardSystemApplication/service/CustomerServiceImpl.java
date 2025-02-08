package com.infosys.amex.RewardSystemApplication.service;

import com.infosys.amex.RewardSystemApplication.model.Customer;
import com.infosys.amex.RewardSystemApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer addCustomerDetails(Customer customer) {

        customer.setCashback(calculateCashback(customer.getAmount()));

        return customerRepository.save(customer);
    }

    private double calculateCashback(Double amount) {

        double cashBackRate = amount.compareTo(Double.valueOf(100)) > 0 ? Double.valueOf(0.2) : Double.valueOf(0.05);

        return (amount*cashBackRate) ;
    }

    @Override
    public List<Customer> getAllCustomer() {

        return ((List<Customer>) customerRepository.findAll());
    }
}
