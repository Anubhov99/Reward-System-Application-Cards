package com.infosys.amex.RewardSystemApplication.service;

import com.infosys.amex.RewardSystemApplication.model.Customer;


import java.util.List;


public interface CustomerService {

    Customer addCustomerDetails(Customer customer);

    List<Customer> getAllCustomer();
}
