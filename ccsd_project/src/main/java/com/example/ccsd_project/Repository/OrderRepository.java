package com.example.ccsd_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ccsd_project.Model.OrderPackage.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> { //to perform CRUD operations
    
    
}
