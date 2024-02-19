package com.dwes.usuario.configuacion;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection as it's not needed for stateless APIs
            .sessionManagement(session -> session.sessionCreationPolicy(STATELESS)) // Use stateless session; session won't be used to store user's state.
            .authorizeHttpRequests(authz -> authz
                    .requestMatchers("/api/v0/usuarios/email").permitAll() // Permitir el acceso sin restricciones a /api/v0/usuarios/email
                .requestMatchers("/api/v0/usuarios/**").permitAll() // Only authenticated users can access /api/v0/usuarios/**
                .anyRequest().authenticated()
                
            		); // All other requests must be authenticated

        return http.build();
    }
}