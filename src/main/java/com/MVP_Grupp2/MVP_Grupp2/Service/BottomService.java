package com.MVP_Grupp2.MVP_Grupp2.Service;

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
    
}
