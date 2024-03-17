package com.MVP_Grupp2.MVP_Grupp2.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MVP_Grupp2.MVP_Grupp2.Model.Bottom;
import com.MVP_Grupp2.MVP_Grupp2.Repository.BottomRepository;

import jakarta.annotation.PostConstruct;


@Service
public class BottomService {

    @Autowired
    private BottomRepository bottomRepository;

      @PostConstruct
    public void init() {
        createBottoms();
    }
    
    @Transactional
    public void createBottoms() {
        Bottom herrbyxor = new Bottom(
            1, // articleNumber
            "Herr", // genderBottom
            BigDecimal.valueOf(500.00),// priceBottom
            "Herrbyxor", // nameBottom
            null, // sizeBottom
            40, // saldoBottom
            null, // ratingBottom
            null, // commentBottom
            "prod_PggZTeD4aGtVLG"
        );
        Bottom dambyxor = new Bottom(
            2,
            "Dam",
            BigDecimal.valueOf(500.00),
            "Dambyxor",
            null,
            80,
            null,
            null, 
            "prod_PggbNGs7UZuSya"
        );

        bottomRepository.save(herrbyxor);
        bottomRepository.save(dambyxor);
    }
    
}
