package com.MVP_Grupp2.MVP_Grupp2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "top")
public class Top {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int articleNumberTop;
    private String genderTop;
    private String priceTop;
    private String nameTop;
    private String sizeTop;
    private int saldoTop;
    private String betygTop;
    private String commentTop;

    public int getArticleNumberTop() {
        return articleNumberTop;
    }
    public void setArticleNumberTop(int articleNumberTop) {
        this.articleNumberTop = articleNumberTop;
    }
    public String getGenderTop() {
        return genderTop;
    }
    public void setGenderTop(String genderTop) {
        this.genderTop = genderTop;
    }
    public String getPriceTop() {
        return priceTop;
    }
    public void setPriceTop(String priceTop) {
        this.priceTop = priceTop;
    }
    public String getNameTop() {
        return nameTop;
    }
    public void setNameTop(String nameTop) {
        this.nameTop = nameTop;
    }
    public String getSizeTop() {
        return sizeTop;
    }
    public void setSizeTop(String sizeTop) {
        this.sizeTop = sizeTop;
    }
    public int getSaldoTop() {
        return saldoTop;
    }
    public void setSaldoTop(int saldoTop) {
        this.saldoTop = saldoTop;
    }
    public String getBetygTop() {
        return betygTop;
    }
    public void setBetygTop(String betygTop) {
        this.betygTop = betygTop;
    }
    public String getCommentTop() {
        return commentTop;
    }
    public void setCommentTop(String commentTop) {
        this.commentTop = commentTop;
    }
    
    
}
