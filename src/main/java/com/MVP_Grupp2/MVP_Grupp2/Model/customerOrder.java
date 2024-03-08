package com.MVP_Grupp2.MVP_Grupp2.Model;

import java.util.Date;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import jakarta.persistence.Table;

@Entity
@Table(name="customerorder")
public class CustomerOrder {
    @Id
    @Column(name="order_number")
    private int order_number;
    @Column(name="ammount")
    private int ammount;
    @Column(name="orderDate")
    private Date orderDate;
    @Column(name="orderSum")
    private int orderSumma;
    @Column(name = "customer_number")
    private UUID customerNumber;
    @Column(name="payment")
    private String payment;
    @Column(name="status")
    private String status;

    public CustomerOrder(){
        
    }

    public CustomerOrder(int order_number, int ammount, Date orderDate, int orderSumma, UUID customerNumber,
            String payment, String status) {
        this.order_number = order_number;
        this.ammount = ammount;
        this.orderDate = orderDate;
        this.orderSumma = orderSumma;
        this.customerNumber = customerNumber;
        this.payment = payment;
        this.status = status;
    }


    public int getOrder_number() {
        return order_number;
    }
    public void setOrder_number(int order_number) {
        this.order_number = order_number;
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

    public UUID getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(UUID customerNumber) {
        this.customerNumber = customerNumber;
    }

}
 