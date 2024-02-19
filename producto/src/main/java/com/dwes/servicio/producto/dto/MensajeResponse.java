package com.dwes.servicio.producto.dto;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeResponse {
    private Date timestamp;
    private String message;
    private String details;
}
