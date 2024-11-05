package com.example.ccsd_project.Controller;

import java.time.LocalDateTime;
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
    List<LocalDateTime> bookings = new ArrayList<>();

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
        model.addAttribute("subtotal", Order.calculateSubTotal(cart));
        return "order";
    }

    @GetMapping("/checkout")
    public String getCheckout(Model model) {
        model.addAttribute("cart", cart);
        model.addAttribute("subtotal", Order.calculateSubTotal(cart));
        model.addAttribute("order", db);
        model.addAttribute("fee", Order.getFee());
        return "checkout";
    }

    @PostMapping("/checkout")
    public String submitOrder(@RequestBody String body,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "isDeliverable", required = false) boolean isDeliverable,
            @RequestParam(value = "street", required = false) String street,
            @RequestParam(value = "postcode", required = false) String postcode,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "bookingdatetime", required = false) String booking,
            @RequestParam(value = "paymentType", required=false) String paymentType) {
                
        //test form
        System.out.println("Body: " + body);
        System.out.println("Email: " + email);
        System.out.println("Is Deliverable: " + isDeliverable);
        System.out.println("Street: " + street);
        System.out.println("Postcode: " + postcode);
        System.out.println("City: " + city);
        System.out.println("Booking Datetime: " + booking);
        System.out.println("PaymentType: " + paymentType);
        
        String orderID = "order#" + UUID.randomUUID().toString();
        // db.add(new Order(orderID, cart));
        // create new order pending payment
        return "redirect:/checkout";
    }

    @PostMapping("/order")
    public String createOrder(Model model) {
        return "redirect:/checkout";
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

    public List<LocalDateTime> getBookedDates() {
        // get bookingTime from all Orders
        return bookings;
    }

}
