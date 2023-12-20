package com.lasitha.practice.repository;

import com.lasitha.practice.controller.signup.UserDTO;

public interface UserRegisterRepository {
    void saveUser(UserDTO userDTO);
}
