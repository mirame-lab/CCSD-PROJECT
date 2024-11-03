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
            new CarSeats("suv", (150 / 5)),
            new CarSeats("4x4", (150 / 5)),
            new CarSeats("crossover", (150 / 5)),
            new CarSeats("mpv", (190 / 5)),
            new CarSeats("mpv luxury", (220 / 5)));

    @GetMapping("/car_seats")
    public List<CarSeats> get() {
        return db;
    }

    @GetMapping("/carseats")
    public String getPage(Model model){
        //put image urls for gallery
        String[] imgUrls = {
            "https://scontent.fmkz1-2.fna.fbcdn.net/v/t39.30808-6/261927975_1086676821906161_7473062148100628391_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeE2Pzizys880oKwT6442fP5brCLbsXu4GJusItuxe7gYhSgeUOLIAr35PRUcTPsSBcS_yTNqOKktK0wtZHf_9aF&_nc_ohc=qhvtrdP-lhgQ7kNvgGoCtbR&_nc_zt=23&_nc_ht=scontent.fmkz1-2.fna&_nc_gid=AkxsViV2SaTZIvdpsxZ141W&oh=00_AYDVzhOuqFIzDmE_1wxHYIibvy8sf6vR2CYSPuUFCkZ7-A&oe=672D2EE6",
            "https://scontent.fmkz1-2.fna.fbcdn.net/v/t39.30808-6/242613346_1045421412698369_3563090678437034352_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeETtkia_nBtgy0OoF0zqOzhlZ2RWUFpIhOVnZFZQWkiE8Ag-2GDYIR8GjMQJTBJuyNhbWvx1u6cNADC9rffJMPH&_nc_ohc=_r8JDtT71sAQ7kNvgH_AFCd&_nc_zt=23&_nc_ht=scontent.fmkz1-2.fna&_nc_gid=AU3i6htF3GW1VMEgU4mdjVN&oh=00_AYBSjXZkcrvdIRa-CSiX13sy5UgH61xxTLfyViWmp5exgg&oe=672CF8D4",
            "https://scontent.fmkz1-1.fna.fbcdn.net/v/t39.30808-6/260321090_1086071908633319_5006886733527156202_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeHdJleRoXDIzjhTlHdH4dEWCLPe_G7XA9kIs978btcD2YD1DiXopVdATa2rGNE95FVxy1ShYhxcLpsxz9Flop-D&_nc_ohc=9bax74aNKyoQ7kNvgFDeFrb&_nc_zt=23&_nc_ht=scontent.fmkz1-1.fna&_nc_gid=As90RqF8lQIVAcGgNZlKqq6&oh=00_AYCjZ8yKHKU9UY7ooNhYcLqVk_I7sWBGQsPZknP3xuUwGw&oe=672D234F",
            "https://scontent.fmkz1-2.fna.fbcdn.net/v/t39.30808-6/250796589_1071288723444971_2664817631501619086_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeHBTZzCWpHNXuyIzxvhbbFU2KxcHZ-WPwDYrFwdn5Y_AENIUz2vs9kEj75FNMXw_8OCb495TaavXGOMuroOmwQL&_nc_ohc=MbsJ2hrzfXIQ7kNvgFtxeal&_nc_zt=23&_nc_ht=scontent.fmkz1-2.fna&_nc_gid=ADE9ds998mRRtHFO7rz4c0G&oh=00_AYAxbGt74eKePRZ0PBeSmsziI-Dh0lfywiLmxBok-O85_A&oe=672D2D9D",
            "https://scontent.fmkz1-2.fna.fbcdn.net/v/t39.30808-6/242613346_1045421412698369_3563090678437034352_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeETtkia_nBtgy0OoF0zqOzhlZ2RWUFpIhOVnZFZQWkiE8Ag-2GDYIR8GjMQJTBJuyNhbWvx1u6cNADC9rffJMPH&_nc_ohc=_r8JDtT71sAQ7kNvgH_AFCd&_nc_zt=23&_nc_ht=scontent.fmkz1-2.fna&_nc_gid=AMR3nf0AZnpQWFb4jL1ym7l&oh=00_AYD0wuJ3lmKx96pxGol_VMaUoHx4DyCNI6hjZRDg3hp23A&oe=672CF8D4",
            "https://scontent.fmkz1-2.fna.fbcdn.net/v/t39.30808-6/241475660_1039421929964984_4133066364869061887_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeEJ_OXeJKXeSxvPv8ixFoXH-arfdX7W5SH5qt91ftblIbWocvQT9o4njgGrpZzTqClpPvENmAXHh0_bf4KFXhes&_nc_ohc=-F5p_mRbb04Q7kNvgHubWJA&_nc_zt=23&_nc_ht=scontent.fmkz1-2.fna&_nc_gid=AQUSZtdBYuA_21FD2UMxT11&oh=00_AYCON-NB4T9_IqRSxkfA1SyUoJToRtyG9R0IiVIb2Xx5jQ&oe=672D151E"
        };
        model.addAttribute("cars",cars);
        model.addAttribute("imgUrls",imgUrls);
        model.addAttribute("carseats",db);
        return "carseats";
    }

}
