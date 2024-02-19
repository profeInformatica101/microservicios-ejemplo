package com.dwes.autorizacion.servicio.cliente;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;


import com.dwes.autorizacion.dto.response.UsuarioResponse;

@FeignClient(name = "USUARIO-SERVICIO")
public interface UsuarioFeignClient {
    /** 
     * OBTENER usuario a partir de EMAIL
     */
    @GetMapping("/api/v0/usuarios/email")
    UsuarioResponse encontrarPorEmail(@RequestParam("email") String email);
}


