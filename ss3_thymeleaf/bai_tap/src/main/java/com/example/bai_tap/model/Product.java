package com.example.bai_tap.model;

public class Product {
    private int id;
    private String name;
    private Double price;
    private String describe;
    private String manufacture;

    public Product() {
    }

    public Product(int id, String name, double price, String describe, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.manufacture = manufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
