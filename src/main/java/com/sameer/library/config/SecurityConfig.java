package com.sameer.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Rule 1: Who is allowed to go where?
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // ONLY Admins can go to the Add Book pages
                        .requestMatchers("/add-book", "/save-book").hasRole("ADMIN")
                        // Anyone logged in can see the home page
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/home", true) // Send everyone to home page after login
                );

        return http.build();
    }

    // Rule 2: Create our Users (The VIP List)
    @Bean
    public UserDetailsService userDetailsService() {
        // Create a regular student
        UserDetails student = User.withDefaultPasswordEncoder()
                .username("student")
                .password("password123")
                .roles("USER")
                .build();

        // Create the librarian/admin
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(student, admin);
    }
}