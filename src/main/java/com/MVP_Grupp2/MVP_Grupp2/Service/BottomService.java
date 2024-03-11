package com.MVP_Grupp2.MVP_Grupp2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MVP_Grupp2.MVP_Grupp2.Model.Bottom;
import com.MVP_Grupp2.MVP_Grupp2.Repository.BottomRepository;


@Service
public class BottomService {

    @Autowired
    private BottomRepository bottomRepository;

    @Transactional
    public Bottom saveBottom(Bottom bottom){
        bottom.setArticle_number(3);
        bottom.setGender("male");
        bottom.setPrice("500 kr");
        bottom.setName("Trousers");
        bottom.setSize("XXL");
        bottom.setSaldo(3);
        bottom.setRating("super");
        bottom.setComment("bla bla");
        System.out.println(bottom);
        return bottomRepository.save(bottom);
    }
    
}
