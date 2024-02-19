package com.dwes.servicio.producto.entidad;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Ingrediente {
	
	private String codigoReferenciaProducto;
    private String elemento;
    private String cantidad; 
	private UnidadMedida unidad;
    
	public enum UnidadMedida {
		l,dl,cl,ml,
		Kg,g,dg,cg,mg
	}
}
