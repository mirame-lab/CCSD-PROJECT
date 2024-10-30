package com.example.ccsd_project.Controller.UserController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;


import com.example.ccsd_project.Model.UserPackage.User;
import com.example.ccsd_project.Service.UserService;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            Model model) {

        if (userService.findUserByUsername(user.getUsername()).isPresent()) {
            result.rejectValue("username", null, "Username is already taken");
        }


        if (result.hasErrors()) {
            return "register";
        }

        userService.registerUser(user);
        return "redirect:/login?success";

        
    }

    // Add a login page handler
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }
}
