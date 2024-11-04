package com.example.ccsd_project.Model.OrderPackage;

import java.util.List;

public class Order {
     private String id, email, address;
     private double subtotal,fee;
     private boolean isDeliverable;
     private List<Cart> cart;

     public Order(String id, List<Cart> cart) {
          this.id = id;
          this.cart = cart;
     }

     public String getAddress() {
          return address;
     }

     public void setAddress(String address) {
          this.address = address;
     }

     public void setSubTotal() {
          final double[] sum = { 0 };
          cart.forEach(n -> sum[0] += n.calculatePrice());
          subtotal = sum[0];
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public List<Cart> getCart() {
          return cart;
     }

     public void setCart(List<Cart> cart) {
          this.cart = cart;
     }

}
