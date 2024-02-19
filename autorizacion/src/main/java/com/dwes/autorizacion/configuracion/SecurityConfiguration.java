package com.dwes.autorizacion.configuracion;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dwes.autorizacion.filtro.JwtAuthenticationFilter;


/**
 * Utiliza WebSecurity para crear FilterChainProxy que realiza la seguridad basada en web para Spring Security. 
 */
@Configuration
@EnableWebSecurity
@EnableFeignClients
public class SecurityConfiguration {
	
	

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    
    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter) {
		this.jwtAuthenticationFilter=jwtAuthenticationFilter;
	}
    
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(request ->           
        request
        .requestMatchers("/api/v0/auth/**").permitAll()
       
        .anyRequest().authenticated())
        .sessionManagement(manager -> manager.sessionCreationPolicy(STATELESS))
        .addFilterBefore(
                jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
return http.build();
    }

    // Otras beans (PasswordEncoder, AuthenticationProvider, etc.) como en tu configuración original
}

