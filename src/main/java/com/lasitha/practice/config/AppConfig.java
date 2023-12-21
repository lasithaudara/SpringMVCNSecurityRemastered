package com.lasitha.practice.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Objects;

@EnableWebMvc
@Configuration
@AllArgsConstructor
@ComponentScan("com.lasitha.practice")
@PropertySource("classpath:app.properties")
public class AppConfig {

    private final Environment env;

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setPrefix("/WEB-INF/views/");
            viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    UserDetailsManager userDetailsManager(){
        return new JdbcUserDetailsManager(dataSource());
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                Objects.requireNonNull(env.getProperty("spring.datasource.url")),
                Objects.requireNonNull(env.getProperty("spring.datasource.username")),
                Objects.requireNonNull(env.getProperty("spring.datasource.password")));

        dataSource.setDriverClassName(Objects.requireNonNull(
                env.getProperty("spring.datasource.driver-class-name")));

        return dataSource;
    }
}
