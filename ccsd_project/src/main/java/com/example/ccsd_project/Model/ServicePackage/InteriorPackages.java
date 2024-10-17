package com.example.ccsd_project.Model.ServicePackage;

import java.util.ArrayList;

public class InteriorPackages extends Services {
    private String packageName, packageDesc;
    public ArrayList<Car> carList = new ArrayList<Car>(); //db
    {        
        carList.add(new Car("small"));
        carList.add(new Car("compact"));
        carList.add(new Car("sedan"));
        carList.add(new Car("sedan luxury"));
        carList.add(new Car("suv"));
        carList.add(new Car("4x4"));
        carList.add(new Car("crossover"));
        carList.add(new Car("mpv"));
        carList.add(new Car("mpv luxury"));
    }

    public InteriorPackages() {
        super.setName("Interior Cleaning Packages");
        super.setCategory("Automotive");
        super.setDescription("Clean entire interior of your car");
    }

    public InteriorPackages(String pkgn, String pkgDesc, int maxDuration) {
        this();
        super.setDuration(maxDuration);
        this.packageName = pkgn;
        this.packageDesc = pkgDesc;

    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }
}
