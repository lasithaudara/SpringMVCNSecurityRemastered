package com.lasitha.practice.controller;

import com.lasitha.practice.controller.signup.UserDTO;
import com.lasitha.practice.service.UserRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginController {

    private final UserRegisterService service;

    @GetMapping("/appLoginPage")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/appSignupPage")
    public String getSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(UserDTO userDTO) {
        service.saveUser(userDTO);
        return "redirect:/appLoginPage";
    }

}
