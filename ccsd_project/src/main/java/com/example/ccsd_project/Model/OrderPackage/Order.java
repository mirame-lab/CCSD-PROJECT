package com.example.ccsd_project.Model.OrderPackage;

import com.example.ccsd_project.Model.ServicePackage.Services;

public class Order {
    // private String id,username;
    private Services[] servicelist;
    private double total;

    Order(Services[] sList){
        this.servicelist = sList;
    }

    public Services[] getServicelist() {
        return servicelist;
    }

    public void setServicelist(Services[] servicelist) {
        this.servicelist = servicelist;
    }
}
