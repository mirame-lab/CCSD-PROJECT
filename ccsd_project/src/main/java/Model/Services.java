package Model;

public class Services {
   private String name, category, description;

    Services(){}
    public Services(String name, String category, String desc) {
        this.name = name;
        this.category = category;
        this.description = desc;
    }
    
    public String getName(){return name;}
    public String getCategory(){return category;}
    public String getDescription(){return description;}

    public void setName(String n){ this.name = n;}
    public void setCategory(String n){ this.category = n;}
    public void setDescription(String n){ this.description = n;}

}

class CarSeats extends Services implements InnerServices{
    private int seatNum;
    private String serviceType,carType;
    private double rate;
    CarSeats(Services s,int seatNum, String carType){
        this.serviceType = s.getName();
        this.seatNum = seatNum;
        this.carType = carType;
    }
    @Override
    public double calculatePrice() {
        if(carType.equalsIgnoreCase(carTypes[0])){
            rate = 140/5;
        }
        return rate*seatNum;
    }
}
