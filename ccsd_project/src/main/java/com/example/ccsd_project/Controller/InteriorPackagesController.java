package com.example.ccsd_project.Controller;

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
import jakarta.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class InteriorPackagesController {
    private static final Logger logger = LoggerFactory.getLogger(InteriorPackagesController.class);

    @Autowired
    private InteriorPackagesRepository interiorPackagesRepository;

    @Autowired
    private CarRepository carRepository;

    @PostConstruct
    public void initData() {
        // Fetch cars from the database after Spring injects the dependencies
        List<Car> persistedCars = carRepository.findAll();
        
        // Check if any InteriorPackages records already exist in the database
        if (interiorPackagesRepository.count() == 0) {
            createInteriorPackage("Package A", "Car cushion + floor panel cleaning.", 2, persistedCars);
            createInteriorPackage("Package B", "Car cushion + floor panel + roof panel cleaning.", 3, persistedCars);
            createInteriorPackage("Full Interior", "Car cushion + floor panel + door panel + dashboard + boot cleaning.", 4, persistedCars);
            createInteriorPackage("Advance Full", "Detach seats and floor carpet. Suitable for old cars aging 5 years above", 2, persistedCars);
        }
    }
    
    @Transactional
    public void createInteriorPackage(String packageName, String description, int duration, List<Car> carList) {
        // Create a new, independent list of Car objects
        List<Car> independentCarList = carRepository.findAllById(
            carList.stream().map(Car::getId).toList()
        );
    
        // Create and save the InteriorPackages with an independent carList
        InteriorPackages interiorPackage = new InteriorPackages(packageName, description, duration, independentCarList);
        interiorPackagesRepository.save(interiorPackage);
    
        logger.info("Created Interior Package: " + packageName + " with car list: " + independentCarList);
    }
    

    @GetMapping("/interiorpackages")
    public String get(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        List<InteriorPackages> carPackages = interiorPackagesRepository.findAll();
        model.addAttribute("carpackages", carPackages);
        return "interiorpackages";
    }
}
