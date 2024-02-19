package com.dwes.servicio.producto.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dwes.servicio.producto.entidad.Producto;
import com.dwes.servicio.producto.servicio.ServicioProducto;





@RestController
@RequestMapping("/api/v0/productos")
public class ControladorProducto {
	
    private static final Logger logger = LoggerFactory.getLogger(ControladorProducto.class);

	
	@Value("${global-message}")
	private String globalMessage;
	
	@Autowired
	ServicioProducto servicio;
	
	@GetMapping
	public ResponseEntity<List<Producto>> mostrarProductos() {
		
		System.out.println(globalMessage);
		
		return ResponseEntity.ok(servicio.obtenerProductos());
	}
	

	 @GetMapping("/{id}")
	  public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
	        logger.info("## getJabonById ## id:({}) " + id);
	        Producto producto  = servicio.buscarPorID(id);
	        return ResponseEntity.ok(producto);
	       
	    }
}
