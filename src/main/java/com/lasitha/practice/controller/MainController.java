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

    @GetMapping("/pageone")
    public String getPageOne(){
        return "pageone";
    }

    @GetMapping("/pagetwo")
    public String getPageTwo(){
        return "pagetwo";
    }

}