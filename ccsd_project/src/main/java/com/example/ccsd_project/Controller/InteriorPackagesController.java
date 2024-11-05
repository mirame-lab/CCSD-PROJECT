package com.example.ccsd_project.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ccsd_project.Model.ServicePackage.Car;
import com.example.ccsd_project.Model.ServicePackage.InteriorPackages;
import com.example.ccsd_project.Repository.CarRepository;
import com.example.ccsd_project.Repository.InteriorPackagesRepository;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class InteriorPackagesController {
    private static final Logger logger = LoggerFactory.getLogger(InteriorPackagesController.class);


    @Autowired
    private InteriorPackagesRepository interiorPackagesRepository;

    @Autowired
    private CarRepository carRepository;

    ArrayList<Car> cars = new CarController().carList;
    

    List<InteriorPackages> db = Arrays.asList(
            new InteriorPackages("Package A", "Car cushion + floor panel cleaning.", 2, cars),
            new InteriorPackages("Package B", "Car cushion + floor panel + roof panel cleaning.", 3, cars),
            new InteriorPackages("Full Interior","Car cushion + floor panel + door panel + dashboard + boot + cleaning.", 4, cars),
            new InteriorPackages("Advance Full","Detach seats and floor carpet. Suitable for old cars aging 5 years above", 2, cars)
    );

    @PostConstruct
    public void initData() {
    // Check if any InteriorPackages already exist in the database
    
    if (interiorPackagesRepository.count() == 0) {
        interiorPackagesRepository.saveAll(db);
    }
}

    @GetMapping("/interiorpackages")    public String get(Model model) {
        // setPriceAllPackages();
        // model.addAttribute("cars", );
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("carpackages", interiorPackagesRepository.findAll());
        return "interiorpackages";
    }

    //function utk senangkan hidup saya
    

    // public void setPrice(Car n, double first, double second) {
    //     if (n.type.equalsIgnoreCase("mpv") || n.type.equalsIgnoreCase("mpv luxury")) {
    //         n.setRate(first);
    //         if (n.type.equals("mpv luxury")) {
    //             n.setRate(n.getRate() + 50);
    //         }
    //     } else {
    //         n.setRate(second);
    //         if (n.type.equalsIgnoreCase("suv")) {
    //             n.setRate(n.getRate() + 30);
    //         }
    //     }
    // }
}
