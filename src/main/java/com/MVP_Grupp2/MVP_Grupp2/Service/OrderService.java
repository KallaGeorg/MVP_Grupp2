package com.MVP_Grupp2.MVP_Grupp2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVP_Grupp2.MVP_Grupp2.Model.CustomerOrder;
import com.MVP_Grupp2.MVP_Grupp2.Repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public CustomerOrder saveOrder(CustomerOrder order){
        return orderRepository.save(order);
    }
    
}
