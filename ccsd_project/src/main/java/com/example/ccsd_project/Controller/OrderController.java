package com.example.ccsd_project.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ccsd_project.Model.OrderPackage.Cart;
import com.example.ccsd_project.Model.OrderPackage.Order;

@Controller
public class OrderController {

    List<Order> db = new ArrayList<>();
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
        model.addAttribute("subtotal",calculateSubTotal());
        return "order";
    }

    @PostMapping("/order")
    public String createOrder(
        Model model
    ){
        String orderID = "order#"+ UUID.randomUUID().toString();
        Order newOrder = new Order(orderID, cart);
        db.add(newOrder); //create new order pending payment
        model.addAttribute("order", db);
        return "checkout";
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


    public double calculateSubTotal(){
        final double[] sum = {0};
        cart.forEach(n-> sum[0]+=n.calculatePrice());
            return sum[0];
       }

}
