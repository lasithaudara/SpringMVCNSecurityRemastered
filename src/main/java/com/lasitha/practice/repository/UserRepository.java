package com.lasitha.practice.repository;

import com.lasitha.practice.controller.signup.AuthorityDTO;
import com.lasitha.practice.controller.signup.CustomUserDTO;
import com.lasitha.practice.controller.signup.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository {
    void saveUser(UserDTO userDTO);
    void saveUser(UserDetails userDetails);
    void changePassword(String oldPassword, String newPassword);
    UserDetails getUserByUserName(String userName);
    List<CustomUserDTO> loadUserByUserName(String userName);
    List<AuthorityDTO> findAuthoritiesByUserId(int userId);
}
