package com.dwes.autorizacion.service.impl;

import java.util.Optional;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.dwes.autorizacion.dto.request.SignUpRequest;
import com.dwes.autorizacion.dto.request.SigninRequest;
import com.dwes.autorizacion.dto.response.JwtAuthenticationResponse;
import com.dwes.autorizacion.dto.response.UsuarioResponse;
import com.dwes.autorizacion.entidad.Role;
import com.dwes.autorizacion.entidad.Usuario;

import com.dwes.autorizacion.service.AuthenticationService;
import com.dwes.autorizacion.service.JwtService;
import com.dwes.autorizacion.servicio.cliente.UsuarioFeignClient;
import com.dwes.autorizacion.util.Util;



@Service
public class AuthenticationServiceImpl implements AuthenticationService {
   
	
	private final UsuarioFeignClient usuarioCliente;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    // Constructor para inyección de dependencias (si usas Spring)
    public AuthenticationServiceImpl(
                                     PasswordEncoder passwordEncoder,
                                     JwtService jwtService,
                                    
                                     UsuarioFeignClient usuarioCliente) {
  
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;

        this.usuarioCliente = usuarioCliente;
    }



    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
     /*   if(userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }*/
        // Corrige la forma de construir el objeto 'User'
        Usuario user = new Usuario();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.getRoles().add(Role.ROLE_USER); // Asegúrate de que Role.USER esté definido correctamente
       // userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
    	 Usuario user =obtenerUsuarioPorEmail(request.getEmail())
                 .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
         String jwt = jwtService.generateToken(user);
         return JwtAuthenticationResponse.builder().token(jwt).build();
    }



    public Optional<Usuario> obtenerUsuarioPorEmail(String userEmail) {
        UsuarioResponse usuarioResponse = usuarioCliente.encontrarPorEmail(userEmail);

        if (usuarioResponse != null) {
            Usuario usuario = Util.mapToUsuario(usuarioResponse);
            return Optional.of(usuario);
        } else {
            return Optional.empty();
        }
    }






  
}