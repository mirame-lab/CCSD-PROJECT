package com.example.ccsd_project.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ccsd_project.Model.OrderPackage.Cart;
import com.example.ccsd_project.Model.OrderPackage.Order;

import java.util.*;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class OrderController {

    ArrayList<Order> db = new ArrayList<Order>();
    List<Cart> cart = new ArrayList<>();

    
    
    @PostMapping("/order/")
    public void createInteriorPackageItem(@RequestBody String body,
    @RequestParam("servicename") String service,@RequestParam("pkgname") String pkg,@RequestParam("carname") String car,
    @RequestParam("packageprice") double price) {
        String id = UUID.randomUUID().toString();
        cart.add(new Cart(id,service,pkg,car,price));
        
    }
    
    @GetMapping("/order/")
    public List<Cart> getCart(){
        return cart;
    }

    @PutMapping("/order/{id}")
    public String updateItemQty(@PathVariable String id,@RequestBody String body){ //@RequestParam("quantity") int qty 
        Optional<Cart> item =
        cart.stream()
        .filter(n -> n.getId().equals(id))
        .findFirst();

        // if (item.isPresent()) {
        //     Cart citem = item.get();
        //     citem.setQuantity(qty);
        //     citem.setPrice(citem.getPrice()*citem.getQuantity());// Modify the variable
        // }
        return body;
    }


}
