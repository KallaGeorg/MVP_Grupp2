package com.MVP_Grupp2.MVP_Grupp2.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoes")
public class Shoes {
    
    @Id
    @Column(name = "article_number")
    private int article_number;
    @Column(name = "gender")
    private String gender;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private String size;
    @Column(name = "saldo")
    private int saldo;
    @Column(name = "rating")
    private String rating;
    @Column(name = "comment")
    private String comment;
    @Column(name = "stripeProductId")
    private String stripeProductId;
  
    

    public Shoes() {

    }
    

    public Shoes(int article_number, String gender, BigDecimal price, String name, String size, int saldo,
            String rating, String comment, String stripeProductId) {
        this.article_number = article_number;
        this.gender = gender;
        this.price = price;
        this.name = name;
        this.size = size;
        this.saldo = saldo;
        this.rating = rating;
        this.comment = comment;
        this.stripeProductId = stripeProductId;
    }


    public int getArticle_number() {
        return article_number;
    }

    public void setArticle_number(int article_number) {
        this.article_number = article_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public String getStripeProductId() {
        return stripeProductId;
    }


    public void setStripeProductId(String stripeProductId) {
        this.stripeProductId = stripeProductId;
    }



  
      
}
