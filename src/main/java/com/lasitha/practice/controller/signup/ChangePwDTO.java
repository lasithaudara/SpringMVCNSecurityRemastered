package com.lasitha.practice.controller.signup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePwDTO {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
