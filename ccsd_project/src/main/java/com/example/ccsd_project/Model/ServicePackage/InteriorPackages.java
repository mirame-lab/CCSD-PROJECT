package com.example.ccsd_project.Model.ServicePackage;


import java.util.List;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("INTERIOR")
public class InteriorPackages extends Services {
    
    private String packageName;
    private String packageDesc;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "interior_package_id") // Foreign key in the Car table
    public List<Car> carList;

    public InteriorPackages() {
        super.setName("Interior Cleaning Packages");
        super.setCategory("Automotive");
        super.setDescription("Clean entire interior of your car");
    }

    public InteriorPackages(String pkgn, String pkgDesc, int maxDuration, List<Car> carList) {
        this();
        super.setDuration(maxDuration);
        this.packageName = pkgn;
        this.packageDesc = pkgDesc;
        this.carList = carList;
    }

    // Getters and setters
    public String getPackageName() { return packageName; }
    public void setPackageName(String packageName) { this.packageName = packageName; }

    public String getPackageDesc() { return packageDesc; }
    public void setPackageDesc(String packageDesc) { this.packageDesc = packageDesc; }

    public List<Car> getCarList() { return carList; }
    public void setCarList(List<Car> carList) { this.carList = carList; }
}
