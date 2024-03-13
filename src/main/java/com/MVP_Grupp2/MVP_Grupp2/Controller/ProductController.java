package com.MVP_Grupp2.MVP_Grupp2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MVP_Grupp2.MVP_Grupp2.Model.Bottom;
import com.MVP_Grupp2.MVP_Grupp2.Model.Shoes;
import com.MVP_Grupp2.MVP_Grupp2.Model.Top;

import com.MVP_Grupp2.MVP_Grupp2.Repository.BottomRepository;
import com.MVP_Grupp2.MVP_Grupp2.Repository.TopRepository;
import com.MVP_Grupp2.MVP_Grupp2.Repository.ShoesRepository;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private BottomRepository bottomRepository;

    @Autowired
    private TopRepository topRepository;

    @Autowired
    private ShoesRepository shoesRepository;


    @GetMapping("/men/bottom")
    public List<Bottom> getMenBottoms() {
        return bottomRepository.findByGender("Herr");
    }

    @GetMapping("/woman/bottom")
    public List<Bottom> getWomanBottoms() {
        return bottomRepository.findByGender("Dam");
    }


    @GetMapping("/men/top")
    public List<Top> getMenTops() {
        return topRepository.findByGender("Herr");
    }

    @GetMapping("/woman/top")
    public List<Top> getWomanTops() {
        return topRepository.findByGender("Dam");
    }


    @GetMapping("/men/shoes")
    public List<Shoes> getManShoes() {
        return shoesRepository.findByGender("Herr");
    }

    @GetMapping("/woman/shoes")
    public List<Shoes> getWomanShoes() {
        return shoesRepository.findByGender("Dam");
    }

    
}
