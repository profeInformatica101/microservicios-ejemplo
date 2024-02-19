package com.dwes.autorizacion.dto.request;

import lombok.Data;

@Data
public class SigninRequest {
    private String email;
    private String password;
}
