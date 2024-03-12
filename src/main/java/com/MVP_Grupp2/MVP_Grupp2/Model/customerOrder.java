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
import jakarta.persistence.Transient;

@Entity
@Table(name="customerorder")
public class CustomerOrder {
    @Id
    @Column(name="order_number")
    private UUID order_number;
    @Column(name="article_number")
    private int article_number;
    @Column(name="ammosunt")
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
    @OneToMany
    @JoinColumn(name="article_number", referencedColumnName="article_number")
    private List<Top> tops;
    @OneToMany
    @JoinColumn(name="article_number", referencedColumnName="article_number")
    private List<Bottom> bottoms;
    @OneToMany
    @JoinColumn(name="article_number", referencedColumnName="article_number")
    private List<Shoes> shoes;
   

    

    public CustomerOrder(){
        
    }

    public CustomerOrder(UUID order_number, int ammount, Date orderDate, int orderSumma, String payment, String status,
            Customer customer, List<Top> tops, List<Bottom> bottoms, List<Shoes> shoes) {
        this.order_number = order_number;
        this.ammount = ammount;
        this.orderDate = orderDate;
        this.orderSumma = orderSumma;
        this.payment = payment;
        this.status = status;
        this.customer = customer;
        this.tops = tops;
        this.bottoms = bottoms;
        this.shoes = shoes;
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



    public List<Top> getTops() {
        return tops;
    }




    public void setTops(List<Top> tops) {
        this.tops = tops;
    }




    public List<Bottom> getBottoms() {
        return bottoms;
    }




    public void setBottoms(List<Bottom> bottoms) {
        this.bottoms = bottoms;
    }



    public List<Shoes> getShoes() {
        return shoes;
    }



    public void setShoes(List<Shoes> shoes) {
        this.shoes = shoes;
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
 