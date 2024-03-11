package com.MVP_Grupp2.MVP_Grupp2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {
    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }

    @GetMapping("/confirmed")
    public String confirmed() {
        return "confirmed";
    }
}