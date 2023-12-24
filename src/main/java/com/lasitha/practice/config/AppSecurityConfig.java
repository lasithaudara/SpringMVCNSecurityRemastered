package com.lasitha.practice.config;

import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@AllArgsConstructor
@EnableWebSecurity(debug=true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* in memory authentication */
       /*auth.inMemoryAuthentication()
               .withUser("lakee")
               .password(passwordEncoder.encode("lakee"))
               .roles("ADMIN")
               .and()
               .withUser("lasitha")
               .password(passwordEncoder.encode("lasitha"))
               .roles("USER");*/

        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder)
                .dataSource(dataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin-dashboard").authenticated()
                .antMatchers("/user-dashboard").authenticated()
                .antMatchers("/change-password-page").authenticated()
                .antMatchers("/home").authenticated()
                .antMatchers("/").permitAll()
                .and()
                .formLogin().loginPage("/login-page")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/home")
                .and()
                .httpBasic()
                .and()
                .logout().logoutUrl("/logout");
    }
}
