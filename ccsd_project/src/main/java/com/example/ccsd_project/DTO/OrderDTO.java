package com.example.ccsd_project.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ccsd_project.Model.OrderPackage.Cart;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private String email;
    private String username;
    private String payment;
    private String[] address; // 0:street, 1:postcode, 2:city
    private double total;
    private boolean deliverable;
    private List<Cart> cart;
    private LocalDateTime bookingTime;
}
