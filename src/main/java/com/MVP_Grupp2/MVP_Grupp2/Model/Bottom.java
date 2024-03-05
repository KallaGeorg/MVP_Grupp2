package com.MVP_Grupp2.MVP_Grupp2.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bottom")
public class Bottom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "articleNumberBottom")
    private int articleNumberBottom;
    @Column(name = "genderBottom")
    private String genderBottom;
    @Column(name = "priceBottom")
    private String priceBottom;
    @Column(name = "nameBottom")
    private String nameBottom;
    @Column(name = "sizeBottom")
    private String sizeBottom;
    @Column(name = "saldoBottom")
    private int saldoBottom;
    @Column(name = "ratingBottom")
    private String ratingBottom;
    @Column(name = "commentBottom")
    private String commentBottom;

    public int getArticleNumberBottom() {
        return articleNumberBottom;
    }
    public void setArticleNumberBottom(int articleNumberBottom) {
        this.articleNumberBottom = articleNumberBottom;
    }
    public String getGenderBottom() {
        return genderBottom;
    }
    public void setGenderBottom(String genderBottom) {
        this.genderBottom = genderBottom;
    }
    public String getPriceBottom() {
        return priceBottom;
    }
    public void setPriceBottom(String priceBottom) {
        this.priceBottom = priceBottom;
    }
    public String getNameBottom() {
        return nameBottom;
    }
    public void setNameBottom(String nameBottom) {
        this.nameBottom = nameBottom;
    }
    public String getSizeBottom() {
        return sizeBottom;
    }
    public void setSizeBottom(String sizeBottom) {
        this.sizeBottom = sizeBottom;
    }
    public int getSaldoBottom() {
        return saldoBottom;
    }
    public void setSaldoBottom(int saldoBottom) {
        this.saldoBottom = saldoBottom;
    }
    public String getRatingBottom() {
        return ratingBottom;
    }
    public void setRatingBottom(String betygBottom) {
        this.ratingBottom = betygBottom;
    }
    public String getCommentBottom() {
        return commentBottom;
    }
    public void setCommentBottom(String commentBottom) {
        this.commentBottom = commentBottom;
    }

    
    
}
