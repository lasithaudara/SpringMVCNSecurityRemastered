package com.lasitha.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String getIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

    @GetMapping("/admin-dashboard")
    public String getPageOne(){
        return "adminDashboard";
    }

    @GetMapping("/user-dashboard")
    public String getPageTwo(){
        return "userDashboard";
    }

}