package com.MVP_Grupp2.MVP_Grupp2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.MVP_Grupp2.MVP_Grupp2.Model.Bottom;

@Repository
public interface BottomRepository extends JpaRepository <Bottom,Integer> {
    
    List<Bottom> findByGender(String gender);
   
}
