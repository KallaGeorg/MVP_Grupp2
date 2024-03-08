package com.MVP_Grupp2.MVP_Grupp2.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoes")
public class Shoes {
    
    @Id
    @Column(name = "articleNumber")
    private int articleNumber;
    @Column(name = "genderShoes")
    private String genderShoes;
    @Column(name = "priceShoes")
    private String priceShoes;
    @Column(name = "nameShoes")
    private String nameShoes;
    @Column(name = "sizeShoes")
    private String sizeShoes;
    @Column(name = "saldoShoes")
    private int saldoShoes;
    @Column(name = "betygShoes")
    private String betygShoes;
    @Column(name = "commentShoes")
    private String commentShoes;

    public Shoes() {

    }
    
    public Shoes(int articleNumber, String genderShoes, String priceShoes, String nameShoes, String sizeShoes,
            int saldoShoes, String betygShoes, String commentShoes) {
        this.articleNumber = articleNumber;
        this.genderShoes = genderShoes;
        this.priceShoes = priceShoes;
        this.nameShoes = nameShoes;
        this.sizeShoes = sizeShoes;
        this.saldoShoes = saldoShoes;
        this.betygShoes = betygShoes;
        this.commentShoes = commentShoes;
    }
    public int getArticleNumber() {
        return articleNumber;
    }
    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
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
    public String getCommentShoes() {
        return commentShoes;
    }
    public void setCommentShoes(String commentShoeString) {
        this.commentShoes = commentShoeString;
    }

    
}
