package com.lasitha.practice.repository;

import com.lasitha.practice.controller.signup.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class IUserRegisterRepository implements UserRegisterRepository {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public void saveUser(UserDTO userDTO) {
        String queryInsertUser = "INSERT INTO users values (?,?,?)";
        String queryInsertAuthorities = "INSERT INTO authorities values (?,?)";
        jdbcTemplate.update(queryInsertUser,
                userDTO.getUsername(), userDTO.getPassword(), userDTO.getEnabled());
        jdbcTemplate.update(queryInsertAuthorities,
                userDTO.getUsername(), "USER");

    }
}
