package com.lasitha.practice.service;

import com.lasitha.practice.controller.signup.ChangePwDTO;
import com.lasitha.practice.controller.signup.UserDTO;
import com.lasitha.practice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
@AllArgsConstructor
public class IUserService implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    @Override
    public void saveUser(UserDTO userDTO) {
       /*String encodedPassword =  passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        userDTO.setEnabled(1);*/

       /*repository.saveUser(userDTO);*/

        repository.saveUser(mapToUD.apply(userDTO, passwordEncoder));
    }

    @Override
    public String changePassword(String username, ChangePwDTO changePwDTO) {
        String newPassword = changePwDTO.getNewPassword();
        if(!changePwDTO.getConfirmPassword().equals(newPassword))
            return "redirect:/change-password-page?notMatch";

        String inputCurrentPassword = changePwDTO.getOldPassword();
        if (confirmPassword(username, inputCurrentPassword)) {
            repository.changePassword(inputCurrentPassword, passwordEncoder.encode(newPassword));
            return "redirect:/login-page"; }

        return "redirect:/change-password-page?invalid";
    }

    private static final BiFunction<UserDTO, PasswordEncoder, UserDetails> mapToUD =
            (userDTO, encoder) -> User.withUsername(userDTO.getUsername())
                    .password(userDTO.getPassword())
                    .passwordEncoder(encoder::encode)
                    .authorities("USER", "ADMIN")
                    .build();

    private boolean confirmPassword(String username, String inputCurrentPassword){
        UserDetails userByUserName = repository.getUserByUserName(username);
        String currentEncodedPassword = userByUserName.getPassword();
        return passwordEncoder.matches(inputCurrentPassword, currentEncodedPassword);
    }
}
