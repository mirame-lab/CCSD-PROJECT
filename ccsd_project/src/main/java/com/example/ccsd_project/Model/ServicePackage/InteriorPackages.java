package com.example.ccsd_project.Model.ServicePackage;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("INTERIOR")
public class InteriorPackages extends Services {
    
    private String packageName;
    private String packageDesc;

    @ManyToMany
    @JoinTable(
        name = "interior_package_car",
        joinColumns = @JoinColumn(name = "interior_package_id"),
        inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    @JsonManagedReference
    private List<Car> carList;

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

    @Override
    public String toString() {
    return "InteriorPackages{" +
            "id=" + getId() +
            ", packageName='" + packageName + '\'' +
            ", packageDesc='" + packageDesc + '\'' +
            ", carList=" + carList.stream().map(Car::getType).toList() +
            '}';
    }
}
