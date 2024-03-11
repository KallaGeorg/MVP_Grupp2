package com.MVP_Grupp2.MVP_Grupp2.Service;

//import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
//import java.util.ArrayList;
//import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.MVP_Grupp2.MVP_Grupp2.Model.Bottom;
import com.MVP_Grupp2.MVP_Grupp2.Model.Shoes;
import com.MVP_Grupp2.MVP_Grupp2.Model.Top;
import com.MVP_Grupp2.MVP_Grupp2.Repository.BottomRepository;
import com.MVP_Grupp2.MVP_Grupp2.Repository.ShoesRepository;
/*
import com.MVP_Grupp2.MVP_Grupp2.Model.Customer;
import com.MVP_Grupp2.MVP_Grupp2.Model.CustomerOrder;
import com.MVP_Grupp2.MVP_Grupp2.Repository.CustomerRepository;
import com.MVP_Grupp2.MVP_Grupp2.Repository.OrderRepository;
//import com.MVP_Grupp2.MVP_Grupp2.Model.Article;    */
import com.MVP_Grupp2.MVP_Grupp2.Repository.TopRepository;

@Service
public class MockService {
  /* 
  private CustomerRepository customerRepository;

  private OrderRepository orderRepository;  */
      
  @Autowired
  private BottomRepository bottomRepository;
  private TopRepository topRepository;
  private ShoesRepository shoesRepository;

  public MockService(BottomRepository bottomRepository, TopRepository topRepository, ShoesRepository shoesRepository) {
    /*  this.orderRepository = orderRepository;
    this.customerRepository = customerRepository;*/
    this.bottomRepository = bottomRepository;
    this.topRepository = topRepository;
    this.shoesRepository = shoesRepository;
        
    /* int order_number = generateOrderNumber();
    CustomerOrder order = new CustomerOrder();
    order.setOrder_number(order_number);
    order.setOrderDate(new Date());
    order.setOrderSumma(100);
    order.setPayment("Credit Card"); 
    order.setStatus("Pending");
        
    Customer customer = new Customer();
    customer.setName("John Doe");
    customer.setAdress("123 Main St");
    customer.setEmail("john@example.com");
    customer.setPassword("password123");
    customer.setPayment("Credit Card");
    customer.setOrder(order);
              
    
    saveOrder(order, customer); */
    createBottoms();
    createTops();
    createShoes();

  }

  private void createBottoms() {
    Bottom herrbyxor = new Bottom(
      1, // articleNumber
      "Herr", // genderBottom
      "500 SEK", // priceBottom
      "Herrbyxor", // nameBottom
      null, // sizeBottom
      40, // saldoBottom
      null, // ratingBottom
      null // commentBottom
    );
    Bottom dambyxor = new Bottom(
      2,
      "Dam",
      "600 SEK",
      "Dambyxor",
      null,
      80,
      null,
      null
    );

    bottomRepository.save(herrbyxor);
    bottomRepository.save(dambyxor);
  }

  private void createTops() {
    Top herrtop = new Top(
      11, 
      "Herr", 
      "200", 
      "T-shirt Herr", 
      null, 
      150, 
      null, 
      null
      );
    Top damtop = new Top(
      12, 
      "Dam", 
      "200", 
      "T-shirt Dam", 
      null, 
      100, 
      null, 
      null
    );
    
    topRepository.save(herrtop);
    topRepository.save(damtop);

  }


  private void createShoes() {
    Shoes herrshoes = new Shoes(
      21, 
      "Herr", 
      "800", 
      "Herrskor", 
      null, 
      60, 
      null, 
      null
    );
    Shoes damshoes = new Shoes(
      22, 
      "Dam", 
      "600", 
      "Damskor", 
      null, 
      60, 
      null, 
      null
    );

    shoesRepository.save(herrshoes);
    shoesRepository.save(damshoes);

  }






  /*
  @Transactional
    public void saveOrder(CustomerOrder order, Customer customer) {
      Customer savedCustomer = customerRepository.save(customer);
      UUID customerNumber = savedCustomer.getCustomerNumber();
      order.setCustomerNumber(customerNumber);
      orderRepository.save(order);
    }

    private int generateOrderNumber() {
      // Generate a timestamp-based order number
      long currentTime = System.currentTimeMillis();
      // Append a random number to the timestamp to ensure uniqueness
      Random random = new Random();
      int randomNumber = random.nextInt(100000); // Generate a random number with 5 digits
      // Concatenate timestamp and random number, ensuring it doesn't exceed the maximum integer value
      long concatenatedNumber = Long.parseLong(String.valueOf(currentTime % 1000000000) + String.format("%05d", randomNumber));
      // Truncate the concatenated number to fit within the integer range
      return (int) concatenatedNumber;
    }  */

}



