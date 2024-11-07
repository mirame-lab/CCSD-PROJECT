package com.example.ccsd_project.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ccsd_project.Model.ServicePackage.Carpet;

import org.springframework.ui.Model;

@Controller
public class CarpetController {
    List<Carpet> carpetRates = Arrays.asList(
        new Carpet("Commercial",0.60),
        new Carpet("Domestic",1)
    );

    @GetMapping("/carpet")
    public String getPage(Model model){
        String[] imgUrls = {
            "https://scontent.fmkz1-1.fna.fbcdn.net/v/t39.30808-6/448033943_897880135686235_5747145120142391897_n.jpg?stp=cp6_dst-jpg&_nc_cat=102&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeHIUCM_SFFD7-7-ySCyJlHzsnl5ZCcJIOWyeXlkJwkg5ec8PQa6fAznn2tG49PHsbUTWeSl9bJtVFz4xur8ejPu&_nc_ohc=ABsRLhBcm28Q7kNvgFDRfZ2&_nc_zt=23&_nc_ht=scontent.fmkz1-1.fna&_nc_gid=AfbIh22RYXuSOWPJnbzTpEy&oh=00_AYC7TWHwCCVt7oPEjXunhA3PZ78KAgu4i9qtEIhHlv6pMA&oe=67325C6D",
            "https://scontent.fmkz1-1.fna.fbcdn.net/v/t39.30808-6/447978930_897880149019567_7057165860321615317_n.jpg?stp=cp6_dst-jpg&_nc_cat=103&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeGkKRYBfETDsP5goCJhlyKBWNoNdhQCi8RY2g12FAKLxMd96wG3JnvRz0TQC8RFL3ECpMn1ODIZXGb3yJrQ_vKr&_nc_ohc=eeL5yluu5EwQ7kNvgENjuLq&_nc_zt=23&_nc_ht=scontent.fmkz1-1.fna&_nc_gid=Arck3NHyfwtftl8GRWn30y8&oh=00_AYBSioIvjHOF6KELcr8g0Lr1_osqEP05zqQuH2qgyABOMQ&oe=6732468E",
            "https://scontent.fmkz1-1.fna.fbcdn.net/v/t39.30808-6/448003679_897880089019573_3083315878861406645_n.jpg?stp=cp6_dst-jpg&_nc_cat=111&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeHyniF7zQsPI7gxJ2_QBryB7gZwtaHk49_uBnC1oeTj33mKkjiysbNfOrwD4WmWiZ0fTqz0RO5S_xXspA2dVPOa&_nc_ohc=ueod-ZHYlFkQ7kNvgHKOPF4&_nc_zt=23&_nc_ht=scontent.fmkz1-1.fna&_nc_gid=AHz8SlffqIRF01s2CczIViA&oh=00_AYAnOY5SmGQG_aM09SAMRVMwOTOaGMt7Wz5ZpksxFRgpXw&oe=67326A94",
            "https://scontent.fmkz1-1.fna.fbcdn.net/v/t39.30808-6/448002645_897880079019574_5930884687495551889_n.jpg?stp=cp6_dst-jpg&_nc_cat=103&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeFPTbrMm6tj7hDEZt9oipUP7FEpS2uiMLfsUSlLa6Iwt9xsW3qTF4nt_E529MzYbXEfpZ95z8TZy6ysmhdxWzFy&_nc_ohc=Uvoondbx41AQ7kNvgFY9Xhc&_nc_zt=23&_nc_ht=scontent.fmkz1-1.fna&_nc_gid=As_ne7WdxDaGMC8Ulism39W&oh=00_AYBM8oUS1JH8R_t58TC-HhsAIMlKU1BtFosMwiSjZq0i_g&oe=67325068",
            "https://scontent.fmkz1-1.fna.fbcdn.net/v/t39.30808-6/448002021_897879905686258_6800007348277677906_n.jpg?stp=cp6_dst-jpg&_nc_cat=111&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeGc_65niec4HkNIZHzoMUNF_gAiGf5ZAxv-ACIZ_lkDG5apAAEdwC9OJGmtWN3k4KcjPFTt6zPVoJSKQth-iyme&_nc_ohc=NSeedyMySOAQ7kNvgEi8w5-&_nc_zt=23&_nc_ht=scontent.fmkz1-1.fna&_nc_gid=A2ON7eau570JtukXdwZArdF&oh=00_AYBvmHttquvgqBnT52owyJwPznOcIMso1WSPh7YTTh7tQg&oe=673269C4",
            "https://scontent.fmkz1-1.fna.fbcdn.net/v/t39.30808-6/448031718_897879909019591_1256777446773921333_n.jpg?stp=cp6_dst-jpg&_nc_cat=104&ccb=1-7&_nc_sid=833d8c&_nc_eui2=AeFY6X_36wyvR0oTCEH5zEE8XVogkCoEGdldWiCQKgQZ2YJ8lDsRPQzdCMLQaDaT2kWj17HIZZCChcOo86Chjung&_nc_ohc=bUYsFaVQSesQ7kNvgFSbvXj&_nc_zt=23&_nc_ht=scontent.fmkz1-1.fna&_nc_gid=AZGAh9q_FFlw62k21Dr4AsT&oh=00_AYDr2SoHmlDKHwr0bKCPYeBT8_yuSfZ4dpXwsZFf7MQdWg&oe=67326371",
        };
        model.addAttribute("imgUrls",imgUrls);
        model.addAttribute("rate", carpetRates);
        return "carpet";
    }
}
