package com.lasitha.practice.repository;

import com.lasitha.practice.controller.signup.AuthorityDTO;
import com.lasitha.practice.controller.signup.CustomUserDTO;
import com.lasitha.practice.controller.signup.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
@AllArgsConstructor
public class IUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserDetailsManager userDetailsManager;

    @Override
    public void saveUser(UserDTO userDTO) {
        String queryInsertUser = "INSERT INTO users values (?,?,?)";
        String queryInsertAuthorities = "INSERT INTO authorities values (?,?)";
        jdbcTemplate.update(queryInsertUser,
                userDTO.getUsername(), userDTO.getPassword(), userDTO.getEnabled());
        jdbcTemplate.update(queryInsertAuthorities,
                userDTO.getUsername(), "USER");
    }

    @Override
    public void saveUser(UserDetails userDetails) {
        userDetailsManager.createUser(userDetails);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        userDetailsManager.changePassword(oldPassword, newPassword);
    }

    @Override
    public UserDetails getUserByUserName(String userName) {
        return userDetailsManager.loadUserByUsername(userName);
    }

    @Override
    public List<CustomUserDTO> loadUserByUserName(String userName) {
        String query = "select * from users where name = ?";
        Object[] array = Collections.singletonList(userName).toArray();
        return jdbcTemplate.query(query, array, new BeanPropertyRowMapper<>(CustomUserDTO.class));
    }

    public List<AuthorityDTO> findAuthoritiesByUserId(int userId){
        String query = "select * from authorities where user_id = ?";
        Object[] array = Collections.singletonList(userId).toArray();
        return jdbcTemplate.query(query, array, new BeanPropertyRowMapper<>(AuthorityDTO.class));
    }

}