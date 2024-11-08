package com.example.ccsd_project.Controller;

import java.util.ArrayList;
import java.util.List;
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
public class CartController {

    List<Order> db = new ArrayList<>();
    List<Cart> userCart;
   

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
        String redirect = "redirect:/carseats";

        try {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
            // Generate a unique ID for the new cart item
            String id = UUID.randomUUID().toString();

            // Create a new Cart object with the provided data
            Cart cartItem = new Cart(id, service, pkg, car, price);
            cartItem.setUser(user);

            // Save the cart item to the database using CartRepository
            cartRepository.save(cartItem);
        } catch (Exception e) {
            redirect = "redirect:/login";
        }

        redirectAttributes.addFlashAttribute("submitted", true);
        return redirect;
    }

    @PostMapping("/carseats")
    public String createCarSeatItem(@RequestBody String body,
            @RequestParam("servicename") String service, @RequestParam("pkgname") String pkg,
            @RequestParam("carname") String car,
            @RequestParam("packageprice") double price, RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String redirect = "redirect:/carseats";

        try {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
            // Generate a unique ID for the new cart item
            String id = UUID.randomUUID().toString();

            // Create a new Cart object with the provided data
            Cart cartItem = new Cart(id, service, pkg, car, price);
            cartItem.setUser(user);

            // Save the cart item to the database using CartRepository
            cartRepository.save(cartItem);
        } catch (Exception e) {
            redirect = "redirect:/login";
        }

        redirectAttributes.addFlashAttribute("submitted", true);
        return redirect;
    }

    @GetMapping("/order")
    public String getCart(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
        userCart = cartRepository.findByUser(user);

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

    @PostMapping("/order")
    public String createOrder(Model model) {
        return "redirect:/checkout";
    }

    @DeleteMapping("/order/{id}")
    public String updateProduct(@PathVariable("id") long id) {
        cartRepository.deleteById(id);
        return "redirect:/order";
    }
}
