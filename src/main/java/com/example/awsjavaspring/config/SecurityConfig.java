package com.example.awsjavaspring.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/home").permitAll() // Allow access to home page without authentication
                                .anyRequest().authenticated() // All other requests require authentication
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .defaultSuccessUrl("/welcome", true) // Redirect to welcome page after successful login
                                .failureUrl("/login?error=true") // Redirect to login page with error message on failure
                )
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/home") // Redirect to home page on logout
                );

        return http.build();
    }
}
