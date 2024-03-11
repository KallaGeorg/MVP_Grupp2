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

    public Customer loginCustomer(String email, String password) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null && BCrypt.checkpw(password, customer.getPassword())) {
            System.out.println("Bra att du kan logga in!");
            return customer;
        } else {
            throw new RuntimeException("Invalid email eller lösenord!");
        }
    }

    //Georg's metoder
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}