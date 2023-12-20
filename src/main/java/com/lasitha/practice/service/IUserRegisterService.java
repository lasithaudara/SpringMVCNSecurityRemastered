package com.lasitha.practice.service;

import com.lasitha.practice.controller.signup.UserDTO;
import com.lasitha.practice.repository.UserRegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IUserRegisterService implements UserRegisterService {

    private final PasswordEncoder passwordEncoder;
    private final UserRegisterRepository repository;

    @Override
    public void saveUser(UserDTO userDTO) {
       String encodedPassword =  passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        userDTO.setEnabled(1);
       repository.saveUser(userDTO);
    }
}
