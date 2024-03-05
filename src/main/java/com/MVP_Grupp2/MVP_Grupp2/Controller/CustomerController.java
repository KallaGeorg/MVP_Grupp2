package com.MVP_Grupp2.MVP_Grupp2.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MVP_Grupp2.MVP_Grupp2.Model.Customer;
import com.MVP_Grupp2.MVP_Grupp2.Service.CustomerService;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class CustomerController {

    private final CustomerService customerService;
    
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer.getName(), customer.getAdress(), customer.getEmail(), customer.getPassword(), customer.getPayment());
    }

    @DeleteMapping("/customer/{customerNumber}")
    public void deleteCustomer(@PathVariable UUID customerNumber) {
        customerService.deleteCustomer(customerNumber);
    }

    @GetMapping("/customer/{customerNumber}")
    public Customer getCustomer(@PathVariable UUID customerNumber) {
        return customerService.getCustomer(customerNumber);
    }

    @GetMapping("/customers")
    public Iterable<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }
    
    
}

