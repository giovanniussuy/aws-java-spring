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
                                .requestMatchers("/", "/home").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .defaultSuccessUrl("/welcome", true)
                                .failureUrl("/login?error=true")
                )
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/home")
                );

        return http.build();
    }
}

/*
The "invalid_client" error you're encountering indicates a configuration issue with your OAuth client setup. Even if you are only developing and testing, you must ensure your OAuth client credentials and redirect URI are properly configured. Here's a step-by-step guide to resolve this issue:

Step-by-Step Troubleshooting
Create OAuth2 Credentials in Google Cloud Console:

Go to the Google Cloud Console.
Navigate to APIs & Services > Credentials.
Click Create Credentials and select OAuth 2.0 Client IDs.
Configure the consent screen if you haven't already.
Set up the OAuth client ID:
Application Type: Web application
Name: (Give it a suitable name)
Authorized Redirect URIs: Add http://localhost:8080/login/oauth2/code/google (or your application's equivalent).
 */