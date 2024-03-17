package com.MVP_Grupp2.MVP_Grupp2.Model;

public class Item {
    private String name;
    private String image;
    private Long price;
    private Long count;
    private String stripeProductId;

    public Item() {
    };

    public Item(String name, String image, Long price, Long count, String stripeProductId) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.count = count;
        this.stripeProductId = stripeProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getPrice() {
        return price * 100;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getStripeProductId() {
        return stripeProductId;
    }

    public void setStripeProductId(String stripeProductId) {
        this.stripeProductId = stripeProductId;
    }


}