package com.lasitha.practice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping
    public String getIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String getHome(Principal principal, Authentication auth, Model model){
        model.addAttribute("username", principal.getName());
        return "home";
    }

    @GetMapping("/admin-dashboard")
    public String getPageOne(){
        return "admin-dashboard";
    }

    @GetMapping("/user-dashboard")
    public String getPageTwo(){
        return "user-dashboard";
    }

}