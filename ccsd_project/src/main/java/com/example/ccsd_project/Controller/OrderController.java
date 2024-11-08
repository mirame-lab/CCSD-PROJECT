package com.example.ccsd_project.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ccsd_project.Model.OrderPackage.Cart;
import com.example.ccsd_project.Model.OrderPackage.Order;
import com.example.ccsd_project.Model.UserPackage.User;
import com.example.ccsd_project.Repository.CartRepository;
import com.example.ccsd_project.Repository.OrderRepository;
import com.example.ccsd_project.Repository.UserRepository;
import com.example.ccsd_project.Service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    List<Cart> userCart;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String listOrders(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
        List<Order> orders = orderRepository.findByUser(user);
        model.addAttribute("orders", orders);
        return "orderlist";
    }

    // @GetMapping("/{id}")
    // public String getOrder(@PathVariable Long id, Model model) {
    // Optional<Order> order = orderService.findById(id);
    // order.ifPresent(value -> model.addAttribute("order", value));
    // return order.isPresent() ? "order" : "error";
    // }

    @PostMapping
    public String createOrder(@ModelAttribute Order order,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "isDeliverable", required = false) boolean isDeliverable,
            @RequestParam(value = "street", required = false) String street,
            @RequestParam(value = "postcode", required = false) String postcode,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "bookingdatetime", required = false) String booking,
            @RequestParam(value = "paymentType", required = false) String paymentType) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
        userCart = cartRepository.findByUser(user);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a", Locale.US);
        String[] address = { street, postcode, city };
        LocalDateTime dateTimebooking = booking.isEmpty() ? null : LocalDateTime.parse(booking, formatter);

        System.out.println(userCart);
        Order newOrder = new Order(email, paymentType, address, isDeliverable, dateTimebooking, userCart);
        newOrder.setUser(user);
        newOrder.calculateTotal();
        orderService.save(newOrder);
        
        return "redirect:/orders";
    }

    @PutMapping("/{id}")
    public String updateOrder(@PathVariable Long id, @ModelAttribute Order order) {
        Optional<Order> existingOrder = orderService.findById(id);
        if (existingOrder.isPresent()) {
            Order updatedOrder = existingOrder.get();
            // Update fields as needed
            updatedOrder.setEmail(order.getEmail());
            updatedOrder.setPayment(order.getPayment());
            updatedOrder.setAddress(order.getAddress());
            updatedOrder.setBookingTime(order.getBookingTime());
            updatedOrder.setCart(order.getCart());
            // Save the updated order
            orderService.save(updatedOrder);
            return "redirect:/orders";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
    orderService.deleteById(id);
    return "redirect:/orders";
    }
}
