package com.example.demo;


public class RetailStore {

    private long id;
    private String product;
    private Integer price;

    public RetailStore(long id, String product, Integer price) {
        this.id = id;
        this.product = product;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
