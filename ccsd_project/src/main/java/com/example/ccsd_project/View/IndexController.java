package com.example.ccsd_project.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class IndexController {

    @GetMapping({"/", "/home", "/index"})
    String index(){
        return "index";
    }


    @GetMapping("/navbar")
    String navbar(){
        return "fragments/navbar";
    }

    @GetMapping("/footer")
    String footer(){
        return "fragments/footer";
    }

    @GetMapping("/formheader")
    String formheader(){
        return "fragments/formheader";
    }

    @GetMapping("/gallery")
    public String getGallery() {
        return "fragments/vrmediagallery";
    }
    
    @GetMapping("/orderlist")
    public String getOrderList() {
        return "orderlist";
    }

}
