package com.MVP_Grupp2.MVP_Grupp2.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "top")
public class Top {
    @Id
    @Column(name="article_number")
    private int article_number;
    @Column(name="gender")
    private String gender;
    @Column(name="price")
    private String price;
    @Column(name="name")
    private String name;
    @Column(name="size")
    private String size;
    @Column(name="saldo")
    private int saldo;
    @Column(name="rating")
    private String rating;
    @Column(name="comment")
    private String comment;
    
    

    public Top() {

    }


    public Top(int article_number, String gender, String price, String name, String size, int saldo, String rating,
            String comment) {
        this.article_number = article_number;
        this.gender = gender;
        this.price = price;
        this.name = name;
        this.size = size;
        this.saldo = saldo;
        this.rating = rating;
        this.comment = comment;
        
    }


  

    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getPrice() {
        return price;
    }


    public void setPrice(String price) {
        this.price = price;
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


    public int getArticle_number() {
        return article_number;
    }


    public void setArticle_number(int article_number) {
        this.article_number = article_number;
    }
    
 
    
    
}
