package com.example.ccsd_project.Model.ServicePackage;

public class Upholstery extends Services {
    String furnitureType;
    String type;
    public Upholstery(){
        super.setName("Upholstery");
        super.setCategory("Domestic");
        super.setDescription("Clean your sofas, chairs and mattresses");
    }
    Upholstery(String furnitureType,String type,double rate){
        super.setRate(rate);
        this.furnitureType = furnitureType;
        this.type = type;
    }
}
