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
