package com.example.ccsd_project.Model.OrderPackage;

import java.util.List;

public class Order {
    private String id,username,address;
    private double subtotal;
    private boolean isDeliverable;
    private List<Cart> cart;

   public Order(String id,List<Cart> cart){
        this.id = id;
        this.isDeliverable = isDeliverable;
        this.cart = cart;
   }


}
