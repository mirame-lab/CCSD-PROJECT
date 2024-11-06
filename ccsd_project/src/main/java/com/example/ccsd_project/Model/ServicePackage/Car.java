package com.example.ccsd_project.Model.ServicePackage;

public class Car{
    public String type,typedesc;
    boolean isLuxury = false;
    private double rate;
    public Car(String type, String desc){
        this.type = type;
        typedesc = desc;
    }
    
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }


}