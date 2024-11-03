package com.example.ccsd_project.Controller;

import netscape.javascript.JSObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ccsd_project.Model.OrderPackage.Cart;
import com.example.ccsd_project.Model.OrderPackage.Order;

import java.lang.reflect.Array;
import java.util.*;

@Controller
public class OrderController {

    ArrayList<Order> db = new ArrayList<Order>();
    List<Cart> cart = new ArrayList<>();

    @PostMapping("/interiorpackages")
    public String createInteriorPackageItem(@RequestBody String body,
            @RequestParam("servicename") String service, @RequestParam("pkgname") String pkg,
            @RequestParam("carname") String car,
            @RequestParam("packageprice") double price, RedirectAttributes redirectAttributes) {
        String id = UUID.randomUUID().toString();
        cart.add(new Cart(id, service, pkg, car, price));
        redirectAttributes.addFlashAttribute("submitted", true);
        return "redirect:/interiorpackages";
    }

    @PostMapping("/carseats")
    public String createCarSeatItem(@RequestBody String body,
            @RequestParam("servicename") String service, @RequestParam("pkgname") String pkg,
            @RequestParam("carname") String car,
            @RequestParam("packageprice") double price, RedirectAttributes redirectAttributes) {
        String id = UUID.randomUUID().toString();
        cart.add(new Cart(id, service, pkg, car, price));
        redirectAttributes.addFlashAttribute("submitted", true);
        return "redirect:/carseats";
    }

    @GetMapping("/order")
    public String getCart(Model model) {
        model.addAttribute("cart", cart);
        return "order";
    }

    @PutMapping("/order/{id}")
    public String updateItemQty(Model model, @PathVariable String id, @RequestBody Cart body) { //
        Optional<Cart> item = cart.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst();
        System.out.println(body.getQuantity());
        // if (item.isPresent()) {
        // Cart citem = item.get();
        // citem.setQuantity(Integer.parseInt(body));
        // // Modify the variable
        // }
        model.addAttribute("cart", cart);
        return "order";
    }

}
