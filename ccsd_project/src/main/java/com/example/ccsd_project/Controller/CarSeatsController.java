package com.example.ccsd_project.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ccsd_project.Model.ServicePackage.CarSeats;
import com.example.ccsd_project.Model.ServicePackage.InteriorPackages;

@RestController
public class CarSeatsController {
    List<CarSeats> db = Arrays.asList(
        new CarSeats("small",(140/5)),
        new CarSeats("compact",(150/5)),
        new CarSeats("sedan",(150/5)),
        new CarSeats("sedan luxury",(160/5)),
        new CarSeats("4x4",(150/5)),
        new CarSeats("suv",(150/5)),
        new CarSeats("crossover",(150/5)),
        new CarSeats("mpv",(190/5)),
        new CarSeats("mpv luxury",(220/5))
    );

    @GetMapping("/car_seats")
    public List<CarSeats> get(){
        return db;
    }

}
