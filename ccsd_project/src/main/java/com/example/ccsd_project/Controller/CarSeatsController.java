package com.example.ccsd_project.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ccsd_project.Model.ServicePackage.Car;
import com.example.ccsd_project.Model.ServicePackage.CarSeats;

@Controller
public class CarSeatsController {
    ArrayList<Car> cars = new CarController().carList;
    List<CarSeats> db = Arrays.asList(
            new CarSeats("small", (140 / 5)),
            new CarSeats("compact", (150 / 5)),
            new CarSeats("sedan", (150 / 5)),
            new CarSeats("sedan luxury", (160 / 5)),
            new CarSeats("4x4", (150 / 5)),
            new CarSeats("suv", (150 / 5)),
            new CarSeats("crossover", (150 / 5)),
            new CarSeats("mpv", (190 / 5)),
            new CarSeats("mpv luxury", (220 / 5)));

    @GetMapping("/car_seats")
    public List<CarSeats> get() {
        return db;
    }

    @GetMapping("/carseats")
    public String getPage(Model model){
        //put image urls for gallery here
        String[] imgUrls = {
            "https://via.placeholder.com/1000/2a9d8f/FFFFFF/?text=VRMedia%20Dev",
            "https://via.placeholder.com/1000/0096c7/FFFFFF/?text=VRMedia%20Dev",
            "https://via.placeholder.com/1000/ffb703/FFFFFF/?text=VRMedia%20Dev",
            "https://via.placeholder.com/1000/d4a373/FFFFFF/?text=VRMedia%20Dev",
            "https://via.placeholder.com/1000/ba181b/FFFFFF/?text=VRMedia%20Dev",
            "https://via.placeholder.com/1000/89b0ae/FFFFFF/?text=VRMedia%20Dev"
        };
        model.addAttribute("cars",cars);
        model.addAttribute("imgUrls",imgUrls);
        return "carseats";
    }

}
