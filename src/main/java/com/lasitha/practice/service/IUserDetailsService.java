package com.lasitha.practice.service;

import com.lasitha.practice.controller.signup.CustomUserDTO;
import com.lasitha.practice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Primary
@Service
@AllArgsConstructor
public class IUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<CustomUserDTO> dtoList = userRepository.loadUserByUserName(username);

        CustomUserDTO userDTO = dtoList.stream()
                .filter(user -> user.getName().equals(username))
                .findAny().orElseThrow(() -> new UsernameNotFoundException(username));

        List<SimpleGrantedAuthority> authorities = userRepository.findAuthoritiesByUserId(userDTO.getId()).stream()
                .map(authorityDTO -> new SimpleGrantedAuthority(authorityDTO.getAuthority()))
                .collect(Collectors.toList());

        return mapToUserDetails.apply(userDTO, authorities);
    }

    private static final BiFunction<CustomUserDTO, List<SimpleGrantedAuthority>, UserDetails> mapToUserDetails =
            (userDTO, authorities) ->
                    User.withUsername(userDTO.getName())
                    .password(userDTO.getPassword())
                    .authorities(authorities)
                    .build();
}
