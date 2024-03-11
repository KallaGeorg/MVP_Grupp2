package com.MVP_Grupp2.MVP_Grupp2.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVP_Grupp2.MVP_Grupp2.Model.Top;

@Repository
public interface TopRepository extends JpaRepository <Top, Integer> {
    
}
