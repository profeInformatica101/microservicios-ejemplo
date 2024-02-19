package com.dwes.autorizacion.service;

import com.dwes.autorizacion.dto.request.SignUpRequest;
import com.dwes.autorizacion.dto.request.SigninRequest;
import com.dwes.autorizacion.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
	
	/** REGISTRO */
    JwtAuthenticationResponse signup(SignUpRequest request);
    /** ACCESO a Token JWT */
    JwtAuthenticationResponse signin(SigninRequest request);
   
  
   
}