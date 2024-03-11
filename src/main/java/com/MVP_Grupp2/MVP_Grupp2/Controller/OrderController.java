package com.MVP_Grupp2.MVP_Grupp2.Controller;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MVP_Grupp2.MVP_Grupp2.Model.Bottom;
import com.MVP_Grupp2.MVP_Grupp2.Model.Customer;
import com.MVP_Grupp2.MVP_Grupp2.Model.CustomerOrder;
import com.MVP_Grupp2.MVP_Grupp2.Model.OrderRequest;
import com.MVP_Grupp2.MVP_Grupp2.Model.Shoes;
import com.MVP_Grupp2.MVP_Grupp2.Model.Top;
import com.MVP_Grupp2.MVP_Grupp2.Repository.OrderRepository;

import com.MVP_Grupp2.MVP_Grupp2.Service.CustomerService;


@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    CustomerService customerService;

  
    
    @PostMapping("/orders/{customerNumber}")
public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest, @PathVariable UUID customerNumber ) {
    try {
        Customer customer = customerService.getCustomer(customerNumber); // Update to get customer by email
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not found");
        }
        
        
        CustomerOrder order = new CustomerOrder();
    
        order.setCustomer(customer);
        
        UUID orderNumber = UUID.randomUUID();
        order.setOrder_number(orderNumber);

        customer.setOrder_number(orderNumber);
        customerService.saveCustomer(customer);
        
        if (orderRequest.getTops() != null) {
            order.setTops(orderRequest.getTops());
            // for (Top top : orderRequest.getTops()) {
            //     top.setOrder(order);
            // }
        }

        
        if (orderRequest.getBottoms() != null) {
            order.setBottoms(orderRequest.getBottoms());
            // for (Bottom bottom : orderRequest.getBottoms()) {
            //     bottom.setOrder(order);
            // }
        }

        
        if (orderRequest.getShoes() != null) {
            order.setShoes(orderRequest.getShoes());
            // for (Shoes shoes : orderRequest.getShoes()) {
            //     shoes.setOrder(order);
            // }
        }

       
        orderRepository.save(order);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order placed successfully");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error placing order: " + e.getMessage());
    }
}
}
