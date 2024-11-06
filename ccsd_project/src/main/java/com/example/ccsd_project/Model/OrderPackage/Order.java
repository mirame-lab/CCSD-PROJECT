package com.example.ccsd_project.Model.OrderPackage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false, unique = true)
     private String username;

     @Column(nullable = false, unique = true)
     private String email;

     @Column(nullable = false)
     private String payment;

     @Column
     private String[] address; // 0:street, 1:postcode, 2:city

     @Column(nullable = false)
     private static double total;

     @Column(nullable = false)
     private static boolean isDeliverable;

     @Column(nullable = false)
     private static List<Cart> cart;

     @Column(nullable = false)
     private LocalDateTime bookingTime;

     private static double fee = 20, subtotal;
     private static boolean accepted, isRegistered;
     private int duration;

     public Order(String email, String username, String payment, String[] address, boolean isDeliverable,
               LocalDateTime bookingTime, List<Cart> cart) {
          this.email = email;
          this.address = address;
          this.isDeliverable = isDeliverable;
          this.bookingTime = bookingTime;
          this.cart = cart;
          // pending add rest of the variables from checkout form
          this.subtotal = calculateSubTotal(cart);
          calculateTotal();
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

     public static void calculateTotal() {
          total = subtotal + (isDeliverable ? fee : 0);
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

     public Long getId(){
          return id;
     }
     public void setId(Long id) {
          this.id = id;
     }

     public String getPayment() {
          return payment;
     }

     public void setPayment(String payment) {
          this.payment = payment;
     }

     public static double getTotal() {
          return total;
     }

     public static void setTotal(double total) {
          Order.total = total;
     }

     public static boolean isDeliverable() {
          return isDeliverable;
     }

     public static void setDeliverable(boolean isDeliverable) {
          Order.isDeliverable = isDeliverable;
     }

     public LocalDateTime getBookingTime() {
          return bookingTime;
     }

     public void setBookingTime(LocalDateTime bookingTime) {
          this.bookingTime = bookingTime;
     }

     public static double getSubtotal() {
          return subtotal;
     }

     public static void setSubtotal(double subtotal) {
          Order.subtotal = subtotal;
     }
     
     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }
}
