package com.lasitha.practice.controller;

import com.lasitha.practice.controller.signup.ChangePwDTO;
import com.lasitha.practice.controller.signup.UserDTO;
import com.lasitha.practice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class LoginController {

    private final UserService service;

    @GetMapping("/login-page")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup-page")
    public String getSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(UserDTO userDTO) {
        service.saveUser(userDTO);
        return "redirect:/login-page";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response, Authentication auth) {
        // Clear the security context
        SecurityContextHolder.clearContext();
        // Optionally, invalidate the session
        new SecurityContextLogoutHandler().logout(request, response, auth);
        // Redirect to a login page or any other desired destination
        return "redirect:/login-page";
    }

    @GetMapping("/change-password-page")
    public String getChangePasswordPage() {
        return "change-password";
    }

    @PostMapping("/change-password")
    public String changePassword(Principal principal, ChangePwDTO changePwDTO) {
        return service.changePassword(principal.getName(), changePwDTO);
    }

}
