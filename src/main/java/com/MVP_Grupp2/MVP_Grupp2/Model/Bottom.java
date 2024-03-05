package com.MVP_Grupp2.MVP_Grupp2.Model;

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
    private int articleNumberBottom;
    private String genderBottom;
    private String priceBottom;
    private String nameBottom;
    private String sizeBottom;
    private int saldoBottom;
    private String betygBottom;
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
    public String getBetygBottom() {
        return betygBottom;
    }
    public void setBetygBottom(String betygBottom) {
        this.betygBottom = betygBottom;
    }
    public String getCommentBottom() {
        return commentBottom;
    }
    public void setCommentBottom(String commentBottom) {
        this.commentBottom = commentBottom;
    }

    
    
}
