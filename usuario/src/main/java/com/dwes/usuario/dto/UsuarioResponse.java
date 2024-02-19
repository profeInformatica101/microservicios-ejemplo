package com.dwes.usuario.dto;

import java.util.Set;


import lombok.Data;

@Data
public class UsuarioResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Set<String> roles;
}