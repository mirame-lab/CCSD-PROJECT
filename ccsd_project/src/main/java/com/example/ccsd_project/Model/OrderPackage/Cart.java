package com.example.ccsd_project.Model.OrderPackage;

public class Cart {
    private String service, classification, type;
    private double price;


    public Cart(String s,String c,String t,double p){
        service = s;
        classification = c;
        type = t;
        price = p;
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
}
