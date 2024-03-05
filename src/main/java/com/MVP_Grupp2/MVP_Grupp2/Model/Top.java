package com.MVP_Grupp2.MVP_Grupp2.Model;

import jakarta.persistence.Column;
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
    @Column(name="articleNumberTop")
    private int articleNumberTop;
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
