package com.example.ccsd_project.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ccsd_project.Model.ServicePackage.Car;
import com.example.ccsd_project.Model.ServicePackage.InteriorPackages;

@RestController
public class InteriorPackagesController {

    List<InteriorPackages> db = Arrays.asList(
            new InteriorPackages("Package A", "Car cushion + floor panel cleaning.", 2),
            new InteriorPackages("Package B", "Car cushion + floor panel + roof panel cleaning.", 3),
            new InteriorPackages("Full Interior","Car cushion + floor panel + door panel + dashboard + boot + cleaning.", 4),
            new InteriorPackages("Advance Full","Detach seats and floor carpet. Suitable for old cars aging 5 years above", 2)
            );

    @GetMapping("/interior_packages")
    public List<InteriorPackages> get() {
        setPriceAllPackages();
        return db;
    }

    //function utk kurang serabut
    public void setPriceAllPackages() {
        // Package A
        db.get(0).carList.forEach((n) -> {setPrice(n, 240, 180);});

        // Package B
        db.get(1).carList.forEach((n) -> {setPrice(n, 300, 220);});

        // Full Interior
        db.get(2).carList.forEach((n) -> {setPrice(n, 370, 290);});

        // Full Interior
        db.get(3).carList.forEach((n) -> {setPrice(n, 500, 400);});

        // db.get(0).carList.get(0).setRate(180);
        // db.get(0).carList.get(1).setRate(180);

    }

    public void setPrice(Car n, double first, double second) {
        if (n.type.equalsIgnoreCase("mpv") || n.type.equalsIgnoreCase("mpv luxury")) {
            n.setRate(first);
            if (n.type.equals("mpv luxury")) {
                n.setRate(n.getRate() + 50);
            }
        } else {
            n.setRate(second);
            if (n.type.equalsIgnoreCase("suv")) {
                n.setRate(n.getRate() + 30);
            }
        }
    }
}
