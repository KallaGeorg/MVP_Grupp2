package com.MVP_Grupp2.MVP_Grupp2.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MVP_Grupp2.MVP_Grupp2.Model.Top;
import com.MVP_Grupp2.MVP_Grupp2.Repository.TopRepository;

import jakarta.annotation.PostConstruct;


@Service
public class TopService {

    @Autowired
    private TopRepository topRepository;

      @PostConstruct
    public void init() {
        createTops();
    }
    
    @Transactional
    public void createTops() {
        Top herrtop = new Top(
            11, 
            "Herr", 
             BigDecimal.valueOf(200.00), 
            "T-shirt Herr", 
            null, 
            150, 
            null, 
            null, 
            "prod_PgfvbKaiXLlcUW"
        );
        Top damtop = new Top(
            12, 
            "Dam", 
            BigDecimal.valueOf(200.00), 
            "T-shirt Dam", 
            null, 
            100, 
            null, 
            null, 
            "prod_Pk14FiJJ27CW3w"
        );

        topRepository.save(herrtop);
        topRepository.save(damtop);
    }
}
