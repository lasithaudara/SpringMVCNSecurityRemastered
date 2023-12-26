package com.lasitha.practice.controller.signup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDTO {
    private int id;
    private int user_id;
    private String authority;
}
