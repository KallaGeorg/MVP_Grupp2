package com.MVP_Grupp2.MVP_Grupp2.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MVP_Grupp2.MVP_Grupp2.Model.Shoes;
import com.MVP_Grupp2.MVP_Grupp2.Repository.ShoesRepository;

import jakarta.annotation.PostConstruct;



@Service
public class ShoesService {

    @Autowired
    private ShoesRepository shoesRepository;

    @PostConstruct
    public void init() {
        createShoes();
    }

   @Transactional
    public void createShoes() {
        Shoes herrshoes = new Shoes(
            21, 
            "Herr", 
            BigDecimal.valueOf(1000.00), 
            "Herrskor", 
            null, 
            60, 
            null, 
            null, 
            "prod_Pggcs0sm2KYTKX"
        );
        Shoes damshoes = new Shoes(
            22, 
            "Dam", 
            BigDecimal.valueOf(1000.00), 
            "Damskor", 
            null, 
            60, 
            null, 
            null, 
            "prod_PggdaMmdWB5kj3"
        );

        shoesRepository.save(herrshoes);
        shoesRepository.save(damshoes);
    }
}
