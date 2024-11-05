package com.example.ccsd_project.Model.OrderPackage;

public class Cart {
    private String id;
    private String service, classification, type;
    private double price;
    private int quantity = 1,duration;

    public Cart(String id,String s,String c,String t,double p){
        service = s;
        classification = c;
        type = t;
        price = p;
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public double calculatePrice(){
        return price*quantity;
    }

}
