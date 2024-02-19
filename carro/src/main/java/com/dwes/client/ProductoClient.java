package com.dwes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dwes.dto.ProductoDTO;

@FeignClient(name = "producto")
public interface ProductoClient {
	
    @GetMapping("/api/v0/productos/{id}")
    ProductoDTO obtenerProductoPorId(@PathVariable("id") Long id);

}
