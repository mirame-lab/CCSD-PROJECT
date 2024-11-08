package com.example.ccsd_project.Model.OrderPackage;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ccsd_project.Model.UserPackage.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

     @Column(nullable = false)
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

     public Order(){}
     public Order(String email, String payment, String[] address, boolean isDeliverable,
               LocalDateTime bookingTime, List<Cart> cart) {
          this.email = email;
          this.address = address;
          this.payment = payment;
          this.isDeliverable = isDeliverable;
          this.bookingTime = bookingTime;
          this.cart = cart;
          // pending add rest of the variables from checkout form
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

     public void calculateTotal() {
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

}
