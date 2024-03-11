package com.MVP_Grupp2.MVP_Grupp2.Model;

import java.util.Date;
import java.util.List;
//import java.util.UUID;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customerorder")
public class CustomerOrder {
    @Id
    @Column(name="order_number")
    private UUID order_number;
    @Column(name="ammount")
    private int ammount;
    @Column(name="orderDate")
    private Date orderDate;
    @Column(name="orderSum")
    private int orderSumma;
    @Column(name="payment")
    private String payment;
    @Column(name="status")
    private String status;
    @ManyToOne
    @JoinColumn(name="customer_number", referencedColumnName = "customerNumber") 
    private Customer customer;
    // @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    // private List<Top> tops;
    // @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    // private List<Bottom> bottoms;
    // @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    // private List<Shoes> shoes;
   

    

    public CustomerOrder(){
        
    }






    public CustomerOrder(UUID order_number, int ammount, Date orderDate, int orderSumma, String payment, String status,
            Customer customer) {
        this.order_number = order_number;
        this.ammount = ammount;
        this.orderDate = orderDate;
        this.orderSumma = orderSumma;
        this.payment = payment;
        this.status = status;
        this.customer = customer;
        // this.tops = tops;
        // this.bottoms = bottoms;
        // this.shoes = shoes;
    }






    public int getAmmount() {
        return ammount;
    }




    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }




    public Date getOrderDate() {
        return orderDate;
    }




    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }




    public int getOrderSumma() {
        return orderSumma;
    }




    public void setOrderSumma(int orderSumma) {
        this.orderSumma = orderSumma;
    }




    public String getPayment() {
        return payment;
    }




    public void setPayment(String payment) {
        this.payment = payment;
    }




    public String getStatus() {
        return status;
    }




    public void setStatus(String status) {
        this.status = status;
    }


    public Customer getCustomer() {
        return customer;
    }



    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public UUID getOrder_number() {
        return order_number;
    }



    public void setOrder_number(UUID order_number) {
        this.order_number = order_number;
    }







}
 