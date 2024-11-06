package com.example.ccsd_project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ccsd_project.Model.ServicePackage.Car;
import com.example.ccsd_project.Model.ServicePackage.InteriorPackages;
import com.example.ccsd_project.Repository.CarRepository;
import com.example.ccsd_project.Repository.InteriorPackagesRepository;
import com.example.ccsd_project.Service.CarService;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Controller
public class InteriorPackagesController {

    @Autowired
    private InteriorPackagesRepository interiorPackagesRepository;

    @Autowired
    private CarRepository carRepository;
   
    @Autowired
    private CarService carService;

    @PostConstruct
    public void initData() {
        List<Car> persistedCars = carRepository.findAll();
        if (interiorPackagesRepository.count() == 0) {
            createInteriorPackage("Package A", "Car cushion + floor panel cleaning.", 2, persistedCars, 100, 80);
            createInteriorPackage("Package B", "Car cushion + floor panel + roof panel cleaning.", 3, persistedCars, 150, 120);
            createInteriorPackage("Full Interior", "Car cushion + floor panel + door panel + dashboard + boot cleaning.", 4, persistedCars, 200, 150);
            createInteriorPackage("Advance Full", "Detach seats and floor carpet. Suitable for old cars aging 5 years above", 2, persistedCars, 250, 200);
        }
    }

    @Transactional
    public void createInteriorPackage(String packageName, String description, int duration, List<Car> carList, double rateForType1, double rateForType2) {
        for (Car car : carList) {
            carService.setPrice(car, rateForType1, rateForType2); // Set initial rates
            carRepository.save(car); // Persist rate changes
        }
        InteriorPackages interiorPackage = new InteriorPackages(packageName, description, duration, carList);
        interiorPackagesRepository.save(interiorPackage);
    }
    

    @GetMapping("/interiorpackages")
    public String get(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        List<InteriorPackages> carPackages = interiorPackagesRepository.findAll();
        // for (InteriorPackages interiorPackage : carPackages) {
        //     for (Car car : interiorPackage.getCarList()) {
        //         // Apply rate setting
        //         if (interiorPackage.getPackageName().equals("Package A")) {
        //             carService.setPrice(car, 100, 80);
        //         } else if (interiorPackage.getPackageName().equals("Package B")) {
        //             carService.setPrice(car, 150, 120);
        //         } else if (interiorPackage.getPackageName().equals("Full Interior")) {
        //             carService.setPrice(car, 200, 150);
        //         } else if (interiorPackage.getPackageName().equals("Advance Full")) {
        //             carService.setPrice(car, 250, 200);
        //         }
        //     }
        // }
        model.addAttribute("carpackages", carPackages);
        return "interiorpackages";
    }

    

}
