package com.example.ccsd_project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ccsd_project.Model.OrderPackage.Cart;
import com.example.ccsd_project.Model.UserPackage.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Additional query methods (if needed) can be defined here
    List<Cart> findByUser(User user);
    
}
