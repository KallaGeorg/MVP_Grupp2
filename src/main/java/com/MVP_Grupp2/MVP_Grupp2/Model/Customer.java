package com.MVP_Grupp2.MVP_Grupp2.Model;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customerNumber" )
    private UUID customerNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "adress")
    private String adress;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "payment")
    private String payment;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_number", referencedColumnName = "order_number")
    private CustomerOrder order;

    public Customer(){
        
    }
    
    public Customer(UUID customerNumber, String name, String adress, String email, String password, CustomerOrder order,
    String payment) {
if (customerNumber == null) {
    this.customerNumber = UUID.randomUUID();
} else {
    this.customerNumber = customerNumber;
}
this.name = name;
this.adress = adress;
this.email = email;
this.password = password;
this.order = order;
this.payment = payment;
}


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
  
    public String getPayment() {
        return payment;
    }
    public void setPayment(String payment) {
        this.payment = payment;
    }
    public UUID getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(UUID customerNumber) {
        this.customerNumber = customerNumber;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    } 

    

}
