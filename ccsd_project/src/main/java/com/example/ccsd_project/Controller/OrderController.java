package com.example.ccsd_project.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ccsd_project.Model.OrderPackage.Cart;
import com.example.ccsd_project.Model.OrderPackage.Order;
import java.util.*;

@RestController
public class OrderController {

    ArrayList<Order> db = new ArrayList<Order>();
    List<Cart> cart = new ArrayList<Cart>();
    
    @PostMapping("/order/")
    public List<Cart> createInteriorPackageItem(@RequestBody String body,
    @RequestParam("servicename") String service,@RequestParam("pkgname") String pkg,@RequestParam("carname") String car,
    @RequestParam("packageprice") double price) {
   
        cart.add(new Cart(service,pkg,car,price));
        //TODO: process POST request
        
        return cart;
    }
    


}
