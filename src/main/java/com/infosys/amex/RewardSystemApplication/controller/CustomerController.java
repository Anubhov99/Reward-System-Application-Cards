package com.infosys.amex.RewardSystemApplication.controller;

import com.infosys.amex.RewardSystemApplication.model.Customer;
import com.infosys.amex.RewardSystemApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;




    @PostMapping("/customer/addCD")
    public Customer addCustomerDetails(@RequestBody Customer customer){
        return customerService.addCustomerDetails(customer);
    }


    @GetMapping("/customer/getAllDetails")
    public List<Customer> getAllCustomerDetails(){

        return customerService.getAllCustomer();
    }

}
