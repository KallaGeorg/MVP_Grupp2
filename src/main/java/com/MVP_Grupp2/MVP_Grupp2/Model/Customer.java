package com.MVP_Grupp2.MVP_Grupp2.Model;


import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    @NotNull
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Size(min = 8)
    @Column(name = "password")
    private String password;

    @Column(name = "payment")
    private String payment;
    

    @Column(name = "order_number")
    private UUID order_number;
 
    
    public Customer() {
    }
    public Customer(UUID customerNumber, String name, String adress, String email, String password, String payment) {
        this.customerNumber = UUID.randomUUID();
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.password = password;
        this.payment = payment;

    }
    
  


    public Customer(UUID customerNumber, String name, String adress, @NotNull @Email String email,
            @NotNull @Size(min = 8) String password, String payment, UUID order_number) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.password = password;
        this.payment = payment;
        this.order_number = order_number;
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


    public UUID getOrder_number() {
        return order_number;
    }
    public void setOrder_number(UUID order_number) {
        this.order_number = order_number;
    }

    


}
