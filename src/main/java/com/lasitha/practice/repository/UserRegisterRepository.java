package com.lasitha.practice.repository;

import com.lasitha.practice.controller.signup.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRegisterRepository {
    void saveUser(UserDTO userDTO);
    void saveUser(UserDetails userDetails);
}
