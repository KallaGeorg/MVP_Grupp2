package com.MVP_Grupp2.MVP_Grupp2.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

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
        Customer customer = customerService.getCustomer(customerNumber); 
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not found");
        }
        
        
        CustomerOrder order = new CustomerOrder();
    
        order.setCustomer(customer);
        
        UUID orderNumber = UUID.randomUUID();
        order.setOrder_number(orderNumber);

        customer.setOrder_number(orderNumber);
        customerService.saveCustomer(customer);
        
        
           List<String> topNames = new ArrayList<>();
           List<BigDecimal> topPrices = new ArrayList<>();
           List<Integer> topArticleNumbers = new ArrayList<>();
           if (orderRequest.getTops() != null && !orderRequest.getTops().isEmpty()) {
               for (Top top : orderRequest.getTops()) {
                   topNames.add(top.getName());
                   topPrices.add(top.getPrice());
                   topArticleNumbers.add(top.getArticle_number());
               }
           }
           order.setTopNames(topNames);
           order.setTopPrices(topPrices);
           order.setTopArticleNumbers(topArticleNumbers);

          
           List<String> bottomNames = new ArrayList<>();
           List<BigDecimal> bottomPrices = new ArrayList<>();
           List<Integer> bottomArticleNumbers = new ArrayList<>();
           if (orderRequest.getBottoms() != null && !orderRequest.getBottoms().isEmpty()) {
               for (Bottom bottom : orderRequest.getBottoms()) {
                   bottomNames.add(bottom.getName());
                   bottomPrices.add(bottom.getPrice());
                   bottomArticleNumbers.add(bottom.getArticle_number());
               }
           }
           order.setBottomNames(bottomNames);
           order.setBottomPrices(bottomPrices);
           order.setBottomArticleNumbers(bottomArticleNumbers);

         
           List<String> shoesNames = new ArrayList<>();
           List<BigDecimal> shoesPrices = new ArrayList<>();
           List<Integer> shoesArticleNumbers = new ArrayList<>();
           if (orderRequest.getShoes() != null && !orderRequest.getShoes().isEmpty()) {
               for (Shoes shoes : orderRequest.getShoes()) {
                   shoesNames.add(shoes.getName());
                   shoesPrices.add(shoes.getPrice());
                   shoesArticleNumbers.add(shoes.getArticle_number());
               }
           }
           order.setShoesNames(shoesNames);
           order.setShoesPrices(shoesPrices);
           order.setShoesArticleNumbers(shoesArticleNumbers);
       
        orderRepository.save(order);

        return ResponseEntity.status(HttpStatus.CREATED).body("Order placed successfully");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error placing order: " + e.getMessage());
    }
}
}
