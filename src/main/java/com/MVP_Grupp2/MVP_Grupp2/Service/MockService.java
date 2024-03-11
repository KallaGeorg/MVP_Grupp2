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
  // /* 
  // private CustomerRepository customerRepository;

  // private OrderRepository orderRepository;  */
      
  // @Autowired
  // private BottomRepository bottomRepository;
  // @Autowired
  // private TopRepository topRepository;
  // @Autowired
  // private ShoesRepository shoesRepository;

  // public MockService(BottomRepository bottomRepository, TopRepository topRepository, ShoesRepository shoesRepository) {
    
  //   this.bottomRepository = bottomRepository;
  //   this.topRepository = topRepository;
  //   this.shoesRepository = shoesRepository;
        
   
  //   createBottoms();
  //   createTops();
  //   createShoes();

  // }

  // private void createBottoms() {
  //   Bottom herrbyxor = new Bottom(
  //     1, // articleNumber
  //     "Herr", // genderBottom
  //     "500 SEK", // priceBottom
  //     "Herrbyxor", // nameBottom
  //     null, // sizeBottom
  //     40, // saldoBottom
  //     null, // ratingBottom
  //     null // commentBottom
  //   );
  //   Bottom dambyxor = new Bottom(
  //     2,
  //     "Dam",
  //     "600 SEK",
  //     "Dambyxor",
  //     null,
  //     80,
  //     null,
  //     null
  //   );

  //   bottomRepository.save(herrbyxor);
  //   bottomRepository.save(dambyxor);
  // }

  // private void createTops() {
  //   Top herrtop = new Top(
  //     11, 
  //     "Herr", 
  //     "200", 
  //     "T-shirt Herr", 
  //     null, 
  //     150, 
  //     null, 
  //     null
  //     );
  //   Top damtop = new Top(
  //     12, 
  //     "Dam", 
  //     "200", 
  //     "T-shirt Dam", 
  //     null, 
  //     100, 
  //     null, 
  //     null
  //   );
    
  //   topRepository.save(herrtop);
  //   topRepository.save(damtop);

  // }


  // private void createShoes() {
  //   Shoes herrshoes = new Shoes(
  //     21, 
  //     "Herr", 
  //     "800", 
  //     "Herrskor", 
  //     null, 
  //     60, 
  //     null, 
  //     null
  //   );
  //   Shoes damshoes = new Shoes(
  //     22, 
  //     "Dam", 
  //     "600", 
  //     "Damskor", 
  //     null, 
  //     60, 
  //     null, 
  //     null
  //   );

  //   shoesRepository.save(herrshoes);
  //   shoesRepository.save(damshoes);

  // }



}



