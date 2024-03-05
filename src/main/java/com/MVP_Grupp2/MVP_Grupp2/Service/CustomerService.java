package com.MVP_Grupp2.MVP_Grupp2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVP_Grupp2.MVP_Grupp2.Model.Customer;
import com.MVP_Grupp2.MVP_Grupp2.Repository.CustomerRepository;

@Service
public class CustomerService {
    private final  CustomerRepository customerRepository;
    
    @Autowired
       public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
   

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

 
}
