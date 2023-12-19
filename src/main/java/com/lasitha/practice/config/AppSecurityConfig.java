package com.lasitha.practice.config;

import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@EnableWebSecurity(debug=true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
               .withUser("lakee")
               .password(passwordEncoder.encode("lakee"))
               .roles("ADMIN")
               .and()
               .withUser("lasitha")
               .password(passwordEncoder.encode("lasitha"))
               .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/pageone").authenticated()
                .antMatchers("/pagetwo").authenticated()
                .antMatchers("/home").authenticated()
                .antMatchers("/").permitAll()
                .and()
                .formLogin().loginPage("/appLoginPage")
                    .loginProcessingUrl("/loginProcess")
                    .defaultSuccessUrl("/home")
                .and()
                .httpBasic()
                .and()
                .logout();
    }
}
