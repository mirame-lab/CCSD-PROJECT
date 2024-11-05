package com.example.ccsd_project.Model.OrderPackage;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
     private String id, email, address,payment;
     private double subtotal,fee;
     private boolean isDeliverable,approved=false;
     private List<Cart> cart;
     private LocalDateTime bookingTime;
     private int duration;

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
