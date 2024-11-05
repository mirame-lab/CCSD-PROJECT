package com.example.ccsd_project.Model.OrderPackage;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
     private String id, email,payment;
     private String[] address; //0:street, 1:postcode, 2:city
     private static double fee=20,total,subtotal;
     private static boolean isDeliverable,accepted;
     private static List<Cart> cart;
     private LocalDateTime bookingTime;
     private int duration;

     public Order(String id, List<Cart> cart) {
          this.id = id;
          this.cart = cart;
          //pending add rest of the variables from checkout form
          this.subtotal = calculateSubTotal(cart);
     }

     public String[] getAddress() {
          return address;
     }

     public void setAddress(String[] address) {
          this.address = address;
     }

     public static double calculateSubTotal(List<Cart> cart) {
          final double[] sum = { 0 };
          cart.forEach(n -> sum[0] += n.calculatePrice());
          return subtotal = sum[0];
     }

     public static void calculateTotal(){
          total = subtotal + (isDeliverable?fee:0);
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

     public static double getFee() {
          return fee;
     }
}
