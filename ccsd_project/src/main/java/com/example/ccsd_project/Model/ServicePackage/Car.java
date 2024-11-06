package com.example.ccsd_project.Model.ServicePackage;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    private String typedesc;

    @Column(name = "is_luxury")
    private boolean isLuxury = false;

    private double rate;

    @ManyToMany(mappedBy = "carList")
    @JsonBackReference
    private List<InteriorPackages> interiorPackages;

    public Car() {
        // Default constructor required by JPA
    }

    public Car(String type, String desc) {
        this.type = type;
        this.typedesc = desc;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypedesc() {
        return typedesc;
    }

    public void setTypedesc(String typedesc) {
        this.typedesc = typedesc;
    }

    public boolean isLuxury() {
        return isLuxury;
    }

    public void setLuxury(boolean isLuxury) {
        this.isLuxury = isLuxury;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<InteriorPackages> getInteriorPackages() {
        return interiorPackages;
    }

    public void setInteriorPackages(List<InteriorPackages> interiorPackages) {
        this.interiorPackages = interiorPackages;
    }
}
