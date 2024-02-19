package com.dwes.autorizacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dwes.autorizacion.dto.request.SignUpRequest;
import com.dwes.autorizacion.dto.request.SigninRequest;
import com.dwes.autorizacion.dto.response.JwtAuthenticationResponse;
import com.dwes.autorizacion.service.AuthenticationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v0/auth")
public class AuthenticationController {
	
	@Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        System.out.println("#######" +  request.getEmail() + ", "+ request.getPassword());
    	log.info("AuthenticationController :: signin {} : {}", request.getEmail(), request.getPassword());
    	return ResponseEntity.ok(authenticationService.signin(request));
    }
 


}
