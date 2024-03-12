package com.MVP_Grupp2.MVP_Grupp2.Repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MVP_Grupp2.MVP_Grupp2.Model.CustomerOrder;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, UUID> {
    
}
