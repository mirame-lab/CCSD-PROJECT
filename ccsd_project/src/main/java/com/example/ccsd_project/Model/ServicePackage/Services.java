package com.example.ccsd_project.Model.ServicePackage;

public class Services {
   private String name, category, description;
   private double rate;
   private double duration;

    Services(){}
    public Services(String name, String category, String desc) {
        this.name = name;
        this.category = category;
        this.description = desc;
    }
    
    public String getName(){return name;}
    public String getCategory(){return category;}
    public String getDescription(){return description;}
    public double getRate(){return rate;}
    public double getDuration(){return duration;}
    public void setName(String n){ this.name = n;}
    public void setCategory(String n){ this.category = n;}
    public void setDescription(String n){ this.description = n;}
    public void setRate(double rate) {this.rate = rate;}
    public void setDuration(double d){this.duration = d;}

}

