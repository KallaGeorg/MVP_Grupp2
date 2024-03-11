package com.MVP_Grupp2.MVP_Grupp2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MVP_Grupp2.MVP_Grupp2.Model.Shoes;
import com.MVP_Grupp2.MVP_Grupp2.Repository.ShoesRepository;



@Service
public class ShoesService {

    @Autowired
    private ShoesRepository shoesRepository;

    @Transactional
    public Shoes saveShoes(Shoes shoes){
        shoes.setArticle_number(2);
        shoes.setGender("male");
        shoes.setPrice("600 kr");
        shoes.setName("Super Sneeker");
        shoes.setSize("7 1/2");
        shoes.setSaldo(2);
        shoes.setRating("toppen");
        shoes.setComment("Blub bla bla");
        return shoesRepository.save(shoes);
    }
    
}
