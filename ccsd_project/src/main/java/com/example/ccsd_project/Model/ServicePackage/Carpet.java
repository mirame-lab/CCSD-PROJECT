package com.example.ccsd_project.Model.ServicePackage;

public class Carpet extends Services {
    String type;
    public Carpet(){
        super.setName("Carpet/Floors");
        super.setCategory("Domestic/Commercial");
        super.setDescription("Clean your carpets, carpet floors, and other different types of floors");
    }
    public Carpet(String type,double rate){
        super.setRate(rate);
        this.type = type;
    }
    double calculatePrice(double sqft){
        return getRate()*sqft;
    }
}
