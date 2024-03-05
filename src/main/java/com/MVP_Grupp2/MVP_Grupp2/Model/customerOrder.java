package com.MVP_Grupp2.MVP_Grupp2.Model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="customerOrder")
public class customerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderNumber")
    private int orderNumber;
    @Column(name="ammount")
    private int ammount;
    @ManyToMany
    @JoinTable(name = "order_article", joinColumns = @JoinColumn(name="orderNumber"), inverseJoinColumns = @JoinColumn(name="articleNumber"))
    private List<Article> articles;
    @Column(name="date")
    private Date orderDate;
    @Column(name="orderSum")
    private int orderSumma;
    @ManyToOne
    @JoinColumn(name = "Customer", referencedColumnName = "customerNumber")
    private Customer customer;
    @Column(name="payment")
    private String payment;
    @Column(name="status")
    private String status;

    

    public customerOrder(int orderNumber, int ammount, List<Article> articles, Date orderDate, int orderSumma, Customer customer,
            String payment, String status) {
        this.orderNumber = orderNumber;
        this.ammount = ammount;
        this.articles = articles;
        this.orderDate = orderDate;
        this.orderSumma = orderSumma;
        this.customer = customer;
        this.payment = payment;
        this.status = status;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public int getAmmount() {
        return ammount;
    }
    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
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
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
    
    
}
