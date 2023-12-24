package com.lasitha.practice.repository;

import com.lasitha.practice.controller.signup.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository {
    void saveUser(UserDTO userDTO);
    void saveUser(UserDetails userDetails);
    void changePassword(String oldPassword, String newPassword);
    UserDetails getUserByUserName(String userName);
}
