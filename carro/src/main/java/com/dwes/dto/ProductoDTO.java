package com.dwes.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long id;
    private String codigo; // Suponiendo que sea un UUID representado como String.
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    
    @Override
    public String toString() {
        return "ProductoDTO{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
