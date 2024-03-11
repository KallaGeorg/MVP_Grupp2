package com.MVP_Grupp2.MVP_Grupp2.Service;

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
}
