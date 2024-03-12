package com.MVP_Grupp2.MVP_Grupp2.Model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public class OrderRequest {

    private CustomerOrder order;
    private List<Top> tops;
    private List<Bottom> bottoms;
    private List<Shoes> shoes;
    private UUID customerNumber;
    private String topName;
    private BigDecimal topPrice;
    private int topArticleNumber;
    private String bottomName;
    private BigDecimal bottomPrice;
    private int bottomArticleNumber;
    private String shoesName;
    private BigDecimal shoesPrice;
    private int shoesArticleNumber;

    
    public OrderRequest(CustomerOrder order, List<Top> tops, List<Bottom> bottoms, List<Shoes> shoes,
            UUID customerNumber, String topName, BigDecimal topPrice, int topArticleNumber, String bottomName,
            BigDecimal bottomPrice, int bottomArticleNumber, String shoesName, BigDecimal shoesPrice,
            int shoesArticleNumber) {
        this.order = order;
        this.tops = tops;
        this.bottoms = bottoms;
        this.shoes = shoes;
        this.customerNumber = customerNumber;
        this.topName = topName;
        this.topPrice = topPrice;
        this.topArticleNumber = topArticleNumber;
        this.bottomName = bottomName;
        this.bottomPrice = bottomPrice;
        this.bottomArticleNumber = bottomArticleNumber;
        this.shoesName = shoesName;
        this.shoesPrice = shoesPrice;
        this.shoesArticleNumber = shoesArticleNumber;
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
    public String getTopName() {
        return topName;
    }
    public void setTopName(String topName) {
        this.topName = topName;
    }
    public BigDecimal getTopPrice() {
        return topPrice;
    }
    public void setTopPrice(BigDecimal topPrice) {
        this.topPrice = topPrice;
    }
    public int getTopArticleNumber() {
        return topArticleNumber;
    }
    public void setTopArticleNumber(int topArticleNumber) {
        this.topArticleNumber = topArticleNumber;
    }
    public String getBottomName() {
        return bottomName;
    }
    public void setBottomName(String bottomName) {
        this.bottomName = bottomName;
    }
    public BigDecimal getBottomPrice() {
        return bottomPrice;
    }
    public void setBottomPrice(BigDecimal bottomPrice) {
        this.bottomPrice = bottomPrice;
    }
    public int getBottomArticleNumber() {
        return bottomArticleNumber;
    }
    public void setBottomArticleNumber(int bottomArticleNumber) {
        this.bottomArticleNumber = bottomArticleNumber;
    }
    public String getShoesName() {
        return shoesName;
    }
    public void setShoesName(String shoesName) {
        this.shoesName = shoesName;
    }
    public BigDecimal getShoesPrice() {
        return shoesPrice;
    }
    public void setShoesPrice(BigDecimal shoesPrice) {
        this.shoesPrice = shoesPrice;
    }
    public int getShoesArticleNumber() {
        return shoesArticleNumber;
    }
    public void setShoesArticleNumber(int shoesArticleNumber) {
        this.shoesArticleNumber = shoesArticleNumber;
    }

    
   


    
}
