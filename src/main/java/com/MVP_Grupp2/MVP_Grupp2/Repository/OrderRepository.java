package com.MVP_Grupp2.MVP_Grupp2.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MVP_Grupp2.MVP_Grupp2.Model.customerOrder;

@Repository
public interface OrderRepository extends CrudRepository<customerOrder, Integer> {
    
}
