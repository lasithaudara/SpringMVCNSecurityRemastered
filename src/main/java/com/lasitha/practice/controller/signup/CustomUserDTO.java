package com.lasitha.practice.controller.signup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDTO {
    private int id;
    private String name;
    private String password;
    private String address;
    private String email;
    private int enabled;
}
