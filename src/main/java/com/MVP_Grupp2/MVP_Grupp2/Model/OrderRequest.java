package com.MVP_Grupp2.MVP_Grupp2.Model;

import java.util.List;
import java.util.UUID;


public class OrderRequest {

    private CustomerOrder order;
    private List<Top> tops;
    private List<Bottom> bottoms;
    private List<Shoes> shoes;
    private UUID customerNumber;

    
    
    public OrderRequest(CustomerOrder order, List<Top> tops, List<Bottom> bottoms, List<Shoes> shoes,
            UUID customerNumber) {
        this.order = order;
        this.tops = tops;
        this.bottoms = bottoms;
        this.shoes = shoes;
        this.customerNumber = customerNumber;
    }

    public CustomerOrder getOrder() {
        return order;
    }
  
    public void setOrder(CustomerOrder order) {
        this.order = order;
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

    public UUID getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(UUID customerNumber) {
        this.customerNumber = customerNumber;
    }
   

    
}
