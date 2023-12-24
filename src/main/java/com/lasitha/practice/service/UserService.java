package com.lasitha.practice.service;

import com.lasitha.practice.controller.signup.ChangePwDTO;
import com.lasitha.practice.controller.signup.UserDTO;

public interface UserService {
    void saveUser(UserDTO userDTO);

    String changePassword(String username, ChangePwDTO changePwDTO);
}
