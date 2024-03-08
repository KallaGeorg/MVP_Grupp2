package com.MVP_Grupp2.MVP_Grupp2.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "top")
public class Top {
    @Id
    @Column(name="articleNumber")
    private int articleNumber;
    @Column(name="genderTop")
    private String genderTop;
    @Column(name="priceTop")
    private String priceTop;
    @Column(name="nameTop")
    private String nameTop;
    @Column(name="sizeTop")
    private String sizeTop;
    @Column(name="saldoTop")
    private int saldoTop;
    @Column(name="ratingTop")
    private String ratingTop;
    @Column(name="commentTop")
    private String commentTop;

    

    public Top(int articleNumber, String genderTop, String priceTop, String nameTop, String sizeTop, int saldoTop,
            String ratingTop, String commentTop) {
        this.articleNumber = articleNumber;
        this.genderTop = genderTop;
        this.priceTop = priceTop;
        this.nameTop = nameTop;
        this.sizeTop = sizeTop;
        this.saldoTop = saldoTop;
        this.ratingTop = ratingTop;
        this.commentTop = commentTop;
    }
    public int getArticleNumber() {
        return articleNumber;
    }
    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
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
    public String getRatingTop() {
        return ratingTop;
    }
    public void setRatingTop(String betygTop) {
        this.ratingTop = betygTop;
    }
    public String getCommentTop() {
        return commentTop;
    }
    public void setCommentTop(String commentTop) {
        this.commentTop = commentTop;
    }
    
    
}
