package com.MVP_Grupp2.MVP_Grupp2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVP_Grupp2.MVP_Grupp2.Model.customerOrder;
import com.MVP_Grupp2.MVP_Grupp2.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public customerOrder saveOrder(customerOrder order){
        return orderRepository.save(order);
    }
    
}
