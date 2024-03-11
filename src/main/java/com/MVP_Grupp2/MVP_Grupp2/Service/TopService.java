package com.MVP_Grupp2.MVP_Grupp2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MVP_Grupp2.MVP_Grupp2.Model.Top;
import com.MVP_Grupp2.MVP_Grupp2.Repository.TopRepository;


@Service
public class TopService {

    @Autowired
    private TopRepository topRepository;
    
    @Transactional
    public Top saveTop(Top top){
        top.setArticle_number(1);
        top.setGender("male");
        top.setPrice("450 kr");
        top.setName("Mega top");
        top.setSize("XXS");
        top.setRating("Giga Mega");
        top.setComment("så nöjd som fan");
        return topRepository.save(top);
    }
    
}
