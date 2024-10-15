package com.example.ccsd_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 

@RestController
public class ServiceController {
    Services s1 = new Services("Car Cushion", "Automotive", "null");
    Services s2 = new Services("Interior Packages", "Automotive", "null");
    Services s3 = new Services("Uphosltery", "Domestic", "null");
    Services s4 = new Services("Carpet/Floors", "Domestic/Commercial", "null");

    List<Services> db = List.of(s1,s2,s3,s4);
    @GetMapping("/")
    public List<Services> get() {
        return db;
    }
}


