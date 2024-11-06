// CarService.java
package com.example.ccsd_project.Service;

import org.springframework.stereotype.Service;
import com.example.ccsd_project.Model.ServicePackage.Car;

@Service
public class CarService {

    public void setPrice(Car car, double first, double second) {
        if (car.getType().equalsIgnoreCase("mpv") || car.getType().equalsIgnoreCase("mpv luxury")) {
            car.setRate(first);
            if (car.getType().equals("mpv luxury")) {
                car.setRate(car.getRate() + 50);
            }
        } else {
            car.setRate(second);
            if (car.getType().equalsIgnoreCase("suv")) {
                car.setRate(car.getRate() + 30);
            }
        }
    }
}
