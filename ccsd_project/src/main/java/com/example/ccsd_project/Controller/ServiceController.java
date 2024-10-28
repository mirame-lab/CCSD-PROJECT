package com.example.ccsd_project.Controller;

import java.util.List;

import com.example.ccsd_project.Model.ServicePackage.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    List<Services> db = List.of(new CarSeats(),new InteriorPackages(),new Upholstery(),new Carpet());
    @GetMapping("/services")
    public List<Services> get() {
        return db;
    }
}


