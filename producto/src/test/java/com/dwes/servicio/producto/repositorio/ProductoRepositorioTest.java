package com.dwes.servicio.producto.repositorio;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dwes.servicio.producto.entidad.Categoria;
import com.dwes.servicio.producto.entidad.Producto;



@DataJpaTest
class ProductoRepositorioTest {

	@Autowired
	private ProductoRepositorio productoRepositorio;
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		Categoria cajas = Categoria.builder()
                .nombre("Cajas de Jabón")
                .descripcion("Cajas con varios jabones, ideal para regalo.")
                .build();

        Categoria individuales = Categoria.builder()
                .nombre("Jabones Individuales")
                .descripcion("Jabones vendidos por unidad.")
                .build();
        
        categoriaRepositorio.save(cajas);
        categoriaRepositorio.save(individuales);
        
        Producto p1 = Producto.builder()
                .nombre("Caja de Jabones Deluxe")
                .precio(29.99)
                .descripcion("Una caja elegante con una selección de nuestros mejores jabones.")
                .stock(20)
                .imagenUrl("url_a_imagen_caja_jabones")
                .estado("Disponible")
                .categorias(new HashSet<>(Set.of(cajas)))
                .build();
        productoRepositorio.save(p1);
	}

	
	@Test
	void testTotalRepositorioEsIgualA1() {
		List<Producto> productos = productoRepositorio.findAll();
		
		Assertions.assertThat(productos.size()).isEqualTo(1);
		
	}
	
	@DisplayName("Buscar por categorias añadiendo categoria completa")
	@Test
    public void whenFindByCategorias_thenReturnProductos() {
        // Configuración inicial
        Categoria categoria = new Categoria();
        categoria.setNombre("Electrónica");
        categoria.setDescripcion("Productos electrónicos");
        categoria = categoriaRepositorio.save(categoria);

        Producto producto1 = new Producto();
        producto1.setNombre("Smartphone");
        producto1.setPrecio(500.0);
        producto1.setStock(10);
        producto1.getCategorias().add(categoria);
        productoRepositorio.save(producto1);

        Producto producto2 = new Producto();
        producto2.setNombre("Laptop");
        producto2.setPrecio(1200.0);
        producto2.setStock(5);
        producto2.getCategorias().add(categoria);
        productoRepositorio.save(producto2);

        // Ejecutar la prueba
        List<Producto> productosEncontrados = productoRepositorio.findByCategorias(categoria);

        // Verificaciones
        Assertions.assertThat(productosEncontrados).hasSize(2);
        Assertions.assertThat(productosEncontrados).extracting(Producto::getNombre).containsExactlyInAnyOrder("Smartphone", "Laptop");
    }
	
	@DisplayName("Buscar productos por nombre de categoría")
	@Test
	void whenFindByCategoriasNombre_thenReturnProductos() {
	    // Configuración inicial
	    Categoria categoriaElectronica = Categoria.builder()
	            .nombre("Electrónica")
	            .descripcion("Productos electrónicos")
	            .build();
	    categoriaRepositorio.save(categoriaElectronica);

	    Producto smartphone = Producto.builder()
	            .nombre("Smartphone")
	            .precio(500.0)
	            .descripcion("Un smartphone de última generación")
	            .stock(10)
	            .categorias(Set.of(categoriaElectronica)) // Asegúrate de que el constructor de Producto maneje correctamente las relaciones
	            .build();
	    productoRepositorio.save(smartphone);

	    Producto laptop = Producto.builder()
	            .nombre("Laptop")
	            .precio(1200.0)
	            .descripcion("Una laptop potente para profesionales")
	            .stock(5)
	            .categorias(Set.of(categoriaElectronica))
	            .build();
	    productoRepositorio.save(laptop);

	    // Ejecutar la prueba
	    List<Producto> productosEncontrados = productoRepositorio.findByCategoriasNombre("Electrónica");

	    // Verificaciones
	    Assertions.assertThat(productosEncontrados).hasSize(2);
	    Assertions.assertThat(productosEncontrados).extracting(Producto::getNombre).containsExactlyInAnyOrder("Smartphone", "Laptop");
	}
}
