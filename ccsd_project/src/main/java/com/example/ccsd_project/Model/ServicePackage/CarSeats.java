package com.example.ccsd_project.Model.ServicePackage;

public class CarSeats extends Services {
    private int seatNum;
    public String carType;

    public CarSeats(){
        super.setName("Car Cushion");
        super.setCategory("Automotive");
        super.setDescription("Clean carseat cushion - leather and fabric");
    }
    public CarSeats(String carType,double rate){
        this();
        super.setRate(rate);
        this.carType = carType;
    }

    public void setDuration(int seatNum){ super.setDuration(seatNum*0.5);}//assume 1 seat = 30 min
    public double calculatePrice(int seatNum) {
        return seatNum*getRate();
    }
}
