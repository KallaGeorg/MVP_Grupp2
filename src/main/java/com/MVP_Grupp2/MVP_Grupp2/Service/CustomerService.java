package com.MVP_Grupp2.MVP_Grupp2.Service;


import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.MVP_Grupp2.MVP_Grupp2.Model.Customer;
import com.MVP_Grupp2.MVP_Grupp2.Repository.CustomerRepository;

@Service
public class CustomerService {
    private final  CustomerRepository customerRepository;
    
       public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public Customer registerCustomer(String name, String address, String email, String password, String payment) {
        UUID customerNumber = UUID.randomUUID();
        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        Customer newCustomer = new Customer(customerNumber, name, address, email, encryptedPassword, payment);
        return createCustomer(newCustomer);
    }
    
    public Customer getCustomer(UUID customerNumber) {
        return customerRepository.findById(customerNumber).orElse(null);
    }

    public void deleteCustomer(UUID customerNumber) {
        customerRepository.deleteById(customerNumber);
    }

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
}
}