package com.example.ccsd_project.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ccsd_project.Model.OrderPackage.Cart;
import com.example.ccsd_project.Model.OrderPackage.Order;
import com.example.ccsd_project.Model.UserPackage.User;
import com.example.ccsd_project.Repository.CartRepository;
import com.example.ccsd_project.Repository.UserRepository;

@Controller
public class OrderController {

    List<Order> db = new ArrayList<>();
    List<Cart> cart = new ArrayList<>();
    List<LocalDateTime> bookings = new ArrayList<>();

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/interiorpackages")
    public String createInteriorPackageItem(@RequestBody String body,
            @RequestParam("servicename") String service,
            @RequestParam("pkgname") String pkg,
            @RequestParam("carname") String car,
            @RequestParam("packageprice") double price,
            RedirectAttributes redirectAttributes) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        // Generate a unique ID for the new cart item
        String id = UUID.randomUUID().toString();

        // Create a new Cart object with the provided data
        Cart cartItem = new Cart(id, service, pkg, car, price);
        cartItem.setUser(user);

        // Save the cart item to the database using CartRepository
        cartRepository.save(cartItem);

        // Add a flash attribute to indicate successful submission
        redirectAttributes.addFlashAttribute("submitted", true);

        // Redirect back to the /interiorpackages page
        return "redirect:/interiorpackages";
    }

    @PostMapping("/carseats")
    public String createCarSeatItem(@RequestBody String body,
            @RequestParam("servicename") String service, @RequestParam("pkgname") String pkg,
            @RequestParam("carname") String car,
            @RequestParam("packageprice") double price, RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        // Generate a unique ID for the new cart item
        String id = UUID.randomUUID().toString();

        // Create a new Cart object with the provided data
        Cart cartItem = new Cart(id, service, pkg, car, price);
        cartItem.setUser(user);

        // Save the cart item to the database using CartRepository
        cartRepository.save(cartItem);
        redirectAttributes.addFlashAttribute("submitted", true);
        return "redirect:/carseats";
    }

    @GetMapping("/order")
    public String getCart(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
        List<Cart> userCart = cartRepository.findByUser(user);

        double subtotal = calculateSubTotal(userCart);

        model.addAttribute("cart", userCart);
        model.addAttribute("subtotal", subtotal);

        return "order";
    }

    private double calculateSubTotal(List<Cart> cartItems) {
        return cartItems.stream().mapToDouble(Cart::calculatePrice).sum();
    }

    @GetMapping("/checkout")
    public String getCheckout(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
        List<Cart> userCart = cartRepository.findByUser(user);

        double subtotal = Order.calculateSubTotal(userCart);

        model.addAttribute("cart", userCart);
        model.addAttribute("subtotal", subtotal);
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
            @RequestParam(value = "paymentType", required = false) String paymentType,
            @RequestParam(value = "username", required = false) String username) {

        // test form
        // System.out.println("Email: " + email);
        // System.out.println("Is Deliverable: " + isDeliverable);
        // System.out.println("Street: " + street);
        // System.out.println("Postcode: " + postcode);
        // System.out.println("City: " + city);
        // System.out.println(booking);
        // System.out.println("PaymentType: " + paymentType);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a", Locale.US);
        String[] address = { street, postcode, city };
        LocalDateTime dateTimebooking = booking.isEmpty() ? null : LocalDateTime.parse(booking, formatter);

        db.add(new Order(email, username, paymentType, address, isDeliverable, dateTimebooking, cart));

        // create new order pending payment
        return "redirect:/checkout";
    }

    @PostMapping("/order")
    public String createOrder(Model model) {
        return "redirect:/checkout";
    }

    @DeleteMapping("/order/{id}") 
    public String updateProduct(@PathVariable("id") long id) { 
        cartRepository.deleteById(id);
            return "redirect:/order";
        }

    public List<LocalDateTime> getBookedDates() {
        // get bookingTime from all Orders
        return bookings;
    }

}
