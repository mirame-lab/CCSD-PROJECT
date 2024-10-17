package com.example.ccsd_project.Model.ServicePackage;

public class Car{
    public String type;
    boolean isLuxury = false;
    private double rate;
    public Car(String type){
        this.type = type;
    }
    
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }


}