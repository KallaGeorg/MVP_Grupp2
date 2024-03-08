package com.test.stripe.controller;

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