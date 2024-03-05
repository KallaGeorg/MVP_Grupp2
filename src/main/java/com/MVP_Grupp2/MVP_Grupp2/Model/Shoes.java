package com.MVP_Grupp2.MVP_Grupp2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoes")
public class Shoes {
    
      @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int articleNumberShoes;
    private String genderShoes;
    private String priceShoes;
    private String nameShoes;
    private String sizeShoes;
    private int saldoShoes;
    private String betygShoes;
    private String commentShoeString;

    public int getArticleNumberShoes() {
        return articleNumberShoes;
    }
    public void setArticleNumberShoes(int articleNumberShoes) {
        this.articleNumberShoes = articleNumberShoes;
    }
    public String getGenderShoes() {
        return genderShoes;
    }
    public void setGenderShoes(String genderShoes) {
        this.genderShoes = genderShoes;
    }
    public String getPriceShoes() {
        return priceShoes;
    }
    public void setPriceShoes(String priceShoes) {
        this.priceShoes = priceShoes;
    }
    public String getNameShoes() {
        return nameShoes;
    }
    public void setNameShoes(String nameShoes) {
        this.nameShoes = nameShoes;
    }
    public String getSizeShoes() {
        return sizeShoes;
    }
    public void setSizeShoes(String sizeShoes) {
        this.sizeShoes = sizeShoes;
    }
    public int getSaldoShoes() {
        return saldoShoes;
    }
    public void setSaldoShoes(int saldoShoes) {
        this.saldoShoes = saldoShoes;
    }
    public String getBetygShoes() {
        return betygShoes;
    }
    public void setBetygShoes(String betygShoes) {
        this.betygShoes = betygShoes;
    }
    public String getCommentShoeString() {
        return commentShoeString;
    }
    public void setCommentShoeString(String commentShoeString) {
        this.commentShoeString = commentShoeString;
    }

    
}
