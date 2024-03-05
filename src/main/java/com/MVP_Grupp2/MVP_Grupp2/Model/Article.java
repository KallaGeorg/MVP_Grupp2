package com.MVP_Grupp2.MVP_Grupp2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleNumber;
    private String name;
    private String price;
    
    public int getArticleNumber() {
        return articleNumber;
    }
    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
    
}
