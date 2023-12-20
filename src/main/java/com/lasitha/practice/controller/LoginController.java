package com.lasitha.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/appLoginPage")
    public String getLoginPage() {
        return "login";
    }

}
