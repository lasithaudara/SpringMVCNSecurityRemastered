package com.lasitha.practice.service;

import com.lasitha.practice.controller.signup.UserDTO;
import com.lasitha.practice.repository.UserRegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class IUserRegisterService implements UserRegisterService {

    private final PasswordEncoder passwordEncoder;
    private final UserRegisterRepository repository;

    @Override
    public void saveUser(UserDTO userDTO) {
       /*String encodedPassword =  passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        userDTO.setEnabled(1);*/

       /*repository.saveUser(userDTO);*/

        repository.saveUser(mapToUD.apply(userDTO, passwordEncoder));
    }

    private static final BiFunction<UserDTO, PasswordEncoder, UserDetails> mapToUD =
            (userDTO, encoder) -> User.withUsername(userDTO.getUsername())
                    .password(userDTO.getPassword())
                    .passwordEncoder(encoder::encode)
                    .authorities("USER", "ADMIN")
                    .build();
}
