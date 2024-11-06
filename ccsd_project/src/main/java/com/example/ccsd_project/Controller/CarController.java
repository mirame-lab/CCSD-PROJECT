package com.example.ccsd_project.Controller;

import java.util.ArrayList;

import com.example.ccsd_project.Model.ServicePackage.Car;

public class CarController {
    public ArrayList<Car> carList = new ArrayList<>(); //db

    public CarController(){
        carList.add(new Car("small","Perodua Kancil,Daihatsu Mira, Suzuki Alto, Hyundai Atoz, Kia Picanto"));
        carList.add(new Car("compact","Perodua Myvi, Honda City, Suzuki Swift, Mazda 2, Ford Fiesta, Kia Rio, Hyundai i20, Mitsubishi Attrage, Volkswagen Polo, Renault Clio, Toyota Yaris, Honda Jazz, Nissan Note, Proton Iriz, Perodua Axia, Peugeot 208, Citroen C3"));
        carList.add(new Car("sedan","Honda Accord, Toyota Camry, Nissan Teana, Proton Perdana, Hyundai Sonata, Mazda 6, Volkswagen Jetta, Kia Optima, Subaru Legacy, Honda City, Toyota Vios, Nissan Almera, Proton Saga, Mitsubishi Lancer"));
        carList.add(new Car("sedan luxury","Mercedes-Benz S-Class, BMW 7 Series, Audi A8, Lexus LS, Jaguar XJ, Volvo S90, Porsche Panamera, Maserati Ghibli, Bentley Flying Spur, Rolls-Royce Phantom, Infiniti Q70, Genesis G80, Acura RLX, Land Rover Range Rover Velar, Tesla Model S"));
        carList.add(new Car("suv","Honda CR-V, Toyota RAV4, Nissan X-Trail, Proton X70, Perodua D55L, Mazda CX-5, Ford Everest, Hyundai Tucson, Kia Sportage, Mitsubishi Outlander, Volkswagen Tiguan, BMW X5, Mercedes-Benz GLC, Subaru Forester, Audi Q5, Peugeot 3008"));
        carList.add(new Car("4x4","Toyota Hilux, Nissan Navara, Ford Ranger, Isuzu D-Max, Mitsubishi Triton, Honda HR-V, Land Rover Defender, Mercedes-Benz G-Class, Toyota Fortuner, Nissan Patrol, Jeep Wrangler, Subaru XV, Volkswagen Amarok, Kia Sorento, Renault Koleos"));
        carList.add(new Car("crossover","Honda HR-V, Toyota C-HR, Nissan Qashqai, Proton X50, Mazda CX-30, Hyundai Kona, Kia Seltos, Subaru Crosstrek, Ford EcoSport, Mitsubishi ASX, Peugeot 2008, Chevrolet Tracker, Volkswagen T-Cross, Citroen C3 Aircross, Renault Captur"));
        carList.add(new Car("mpv","Perodua Alza, Honda Mobilio, Toyota Innova, Nissan Serena, Proton Exora, Suzuki Ertiga, Kia Carnival, Hyundai Staria, Mazda 5, Renault Triber, Ford Galaxy, Mitsubishi Delica, Volkswagen Multivan, Changan Alsvin, Toyota Avanza"));
        carList.add(new Car("mpv luxury","Mercedes-Benz V-Class, BMW 2 Series Gran Tourer, Toyota Alphard, Nissan Elgrand, Lexus LM, Kia Carnival (high-spec), Hyundai Staria Premium, Volkswagen Multivan, Audi Q7 (with MPV features), Peugeot Traveller"));
    }
}