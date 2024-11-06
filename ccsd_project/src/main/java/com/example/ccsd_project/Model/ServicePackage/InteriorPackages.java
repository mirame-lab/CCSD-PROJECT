package com.example.ccsd_project.Model.ServicePackage;

import java.util.ArrayList;

public class InteriorPackages extends Services {
    private String packageName, packageDesc;
    public ArrayList<Car> carList; 

    public InteriorPackages() {
        super.setName("Interior Cleaning Packages");
        super.setCategory("Automotive");
        super.setDescription("Clean entire interior of your car");
    }

    public InteriorPackages(String pkgn, String pkgDesc, int maxDuration, ArrayList<Car> carList) {
        this();
        super.setDuration(maxDuration);
        this.packageName = pkgn;
        this.packageDesc = pkgDesc;
        this.carList = carList;
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