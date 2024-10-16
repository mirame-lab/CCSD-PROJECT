package com.example.ccsd_project.Model.ServicePackage;

public class CarSeats extends Services {
    private int seatNum;
    private String carType;

    public CarSeats(){
        super.setName("Car Cushion");
        super.setCategory("Automotive");
        super.setDescription("Clean carseat cushion - leather and fabric");
    }
    CarSeats(String carType,double rate){
        super.setRate(rate);
        this.carType = carType;
    }

    public void setDuration(int seatNum){ super.setDuration(seatNum*0.5);}//assume 1 seat = 30 min
    public double calculatePrice(int seatNum) {
        return seatNum*getRate();
    }
}
