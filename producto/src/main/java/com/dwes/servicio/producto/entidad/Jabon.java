package com.dwes.servicio.producto.entidad;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Table(name = "jabones")
@Entity
@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jabon extends Producto {
    
    // Asumiendo que estos son atributos específicos para Jabón
    private String aroma;
    @ElementCollection
    @CollectionTable(name = "jabon_ingredientes", joinColumns = @JoinColumn(name = "jabon_id"))
    private Set<Ingrediente> ingredientes;
    @Enumerated(EnumType.STRING)
    private Set<PIEL> tiposPiel;
    
    private String lote; // Número de lote o serie
    
    @PastOrPresent
    private LocalDate fechaFabricacion; // Fecha de fabricación
    @FutureOrPresent
    private LocalDate fechaCaducidad; // Fecha de caducidad
   
  

    public enum PIEL {
        // Tipos de piel humana
        NORMAL,
        SECA,
        GRASA,
        MIXTA,
        SENSIBLE,
        ACNEICA,
        MADURA,

        // Tipos de piel de animales de compañía
        PELO_SUAVE, // Para mascotas con pelaje suave, aplicable a la mayoría de perros y gatos
        PELO_SENSIBLE, // Para mascotas con piel sensible, propensas a irritaciones o alergias
        HIPOALERGENICO // Para mascotas (y personas) con necesidades hipoalergénicas específicas
    }

}
