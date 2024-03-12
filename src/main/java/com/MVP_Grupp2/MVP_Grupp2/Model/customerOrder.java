package com.MVP_Grupp2.MVP_Grupp2.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
//import java.util.UUID;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
   

        @ElementCollection
    private List<String> topNames;

    @ElementCollection
    private List<BigDecimal> topPrices;

    @ElementCollection
    private List<Integer> topArticleNumbers;

    @ElementCollection
    private List<String> bottomNames;

    @ElementCollection
    private List<BigDecimal> bottomPrices;

    @ElementCollection
    private List<Integer> bottomArticleNumbers;

    @ElementCollection
    private List<String> shoesNames;

    @ElementCollection
    private List<BigDecimal> shoesPrices;

    @ElementCollection
    private List<Integer> shoesArticleNumbers;

    @ManyToOne
    @JoinColumn(name="customer_number", referencedColumnName = "customerNumber") 
    private Customer customer;
   
   
    public List<String> getTopNames() {
        return topNames;
    }

  
   


    public CustomerOrder(UUID order_number, int ammount, Date orderDate, int orderSumma, String payment, String status,
            List<String> topNames, List<BigDecimal> topPrices, List<Integer> topArticleNumbers,
            List<String> bottomNames, List<BigDecimal> bottomPrices, List<Integer> bottomArticleNumbers,
            List<String> shoesNames, List<BigDecimal> shoesPrices, List<Integer> shoesArticleNumbers,
            Customer customer) {
        this.order_number = order_number;
        this.ammount = ammount;
        this.orderDate = orderDate;
        this.orderSumma = orderSumma;
        this.payment = payment;
        this.status = status;
        this.topNames = topNames;
        this.topPrices = topPrices;
        this.topArticleNumbers = topArticleNumbers;
        this.bottomNames = bottomNames;
        this.bottomPrices = bottomPrices;
        this.bottomArticleNumbers = bottomArticleNumbers;
        this.shoesNames = shoesNames;
        this.shoesPrices = shoesPrices;
        this.shoesArticleNumbers = shoesArticleNumbers;
        this.customer = customer;
    }





    public CustomerOrder() {
        //TODO Auto-generated constructor stub
    }





    public UUID getOrder_number() {
        return order_number;
    }


    public void setOrder_number(UUID order_number) {
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


    public void setTopNames(List<String> topNames) {
        this.topNames = topNames;
    }


    public List<BigDecimal> getTopPrices() {
        return topPrices;
    }


    public void setTopPrices(List<BigDecimal> topPrices) {
        this.topPrices = topPrices;
    }


    public List<Integer> getTopArticleNumbers() {
        return topArticleNumbers;
    }


    public void setTopArticleNumbers(List<Integer> topArticleNumbers) {
        this.topArticleNumbers = topArticleNumbers;
    }


    public List<String> getBottomNames() {
        return bottomNames;
    }


    public void setBottomNames(List<String> bottomNames) {
        this.bottomNames = bottomNames;
    }


    public List<BigDecimal> getBottomPrices() {
        return bottomPrices;
    }


    public void setBottomPrices(List<BigDecimal> bottomPrices) {
        this.bottomPrices = bottomPrices;
    }


    public List<Integer> getBottomArticleNumbers() {
        return bottomArticleNumbers;
    }


    public void setBottomArticleNumbers(List<Integer> bottomArticleNumbers) {
        this.bottomArticleNumbers = bottomArticleNumbers;
    }


    public List<String> getShoesNames() {
        return shoesNames;
    }


    public void setShoesNames(List<String> shoesNames) {
        this.shoesNames = shoesNames;
    }


    public List<BigDecimal> getShoesPrices() {
        return shoesPrices;
    }


    public void setShoesPrices(List<BigDecimal> shoesPrices) {
        this.shoesPrices = shoesPrices;
    }


    public List<Integer> getShoesArticleNumbers() {
        return shoesArticleNumbers;
    }


    public void setShoesArticleNumbers(List<Integer> shoesArticleNumbers) {
        this.shoesArticleNumbers = shoesArticleNumbers;
    }


    public Customer getCustomer() {
        return customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




    


}
 