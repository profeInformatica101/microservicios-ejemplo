package com.dwes.controlador;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dwes.client.ProductoClient;
import com.dwes.dto.ProductoDTO;
import com.dwes.entidad.Carrito;
import com.dwes.repositorio.CarritoRepository;
import com.dwes.servicio.CarritoService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v0/carrito")
public class CarritoController {
	
	@Autowired
    private CarritoService carritoService;
	
	@Autowired
	private CarritoRepository repositorio;
	
	@Autowired
	private ProductoClient productoClient;


	@GetMapping("/test/{id}")
	public ResponseEntity<?> holaMundo(@PathVariable Long id){
		log.info("CarritoController:: carritoId: {}",id);
		
		// Obtener detalles del producto
        ProductoDTO producto = productoClient.obtenerProductoPorId(id); // Suponiendo que este método existe y devuelve un ProductoDTO

        
		return ResponseEntity.ok(producto);
	}

	
	
    // Endpoint para agregar un producto a un carrito
    @PostMapping("/agregar")
    public ResponseEntity<?> agregarProductoAlCarrito(Long carritoId, Long productoId, int cantidad) {
    		 // Buscar el carrito
    		log.info("agregarProductoAlCarrito:: carritoId: {}",carritoId);
    	
            Optional<Carrito> carritoOpt = repositorio.findById(carritoId);
            Carrito carrito = carritoOpt.orElseGet(() -> new Carrito());

            // Obtener detalles del producto
            ProductoDTO producto = productoClient.obtenerProductoPorId(productoId); // Suponiendo que este método existe y devuelve un ProductoDTO

          /**  // Agregar el producto al carrito
            carrito.agregarProducto(producto, cantidad); // Asumiendo que existe un método en Carrito para esto

            // Guardar los cambios
            carrito = repositorio.save(carrito);

            // Convertir a CarritoDTO y devolver
            return convertirACarritoDTO(carrito);*/
            return ResponseEntity.ok("ok");
        }
    


}
