package com.dwes.autorizacion.dto.request;

import lombok.Data;

@Data
public class SignUpRequest {
	 private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
}
