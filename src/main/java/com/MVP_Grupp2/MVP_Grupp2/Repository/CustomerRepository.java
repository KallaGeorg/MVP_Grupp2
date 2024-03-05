package com.MVP_Grupp2.MVP_Grupp2.Repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MVP_Grupp2.MVP_Grupp2.Model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    
}
