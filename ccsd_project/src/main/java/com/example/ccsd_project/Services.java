package com.example.ccsd_project;

public class Services {
   private String name, category, description;

    Services(String name, String category, String desc) {
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
