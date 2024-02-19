package com.dwes.servicio.producto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.dwes.servicio.producto.entidad.Categoria;
import com.dwes.servicio.producto.entidad.Producto;
import com.dwes.servicio.producto.repositorio.CategoriaRepositorio;
import com.dwes.servicio.producto.repositorio.ProductoRepositorio;




@Component
@Profile("default")
public class IniciarDatos implements CommandLineRunner {
    
    @Value("${global-message}")
    private String globalMessage;
    
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public void run(String... args) {
        System.out.println("globalMessage: " + globalMessage);
        
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

        // Asumiendo que tienes una clase Jabon que extiende de Producto
        for (int i = 1; i <= 10; i++) {
            Producto jabon = Producto.builder()
                    .nombre("Jabón Natural " + i)
                    .precio(5.00 * i)
                    .descripcion("Jabón artesanal número " + i + ".")
                    .stock(50 - 3 * i)
                    .imagenUrl("url_a_imagen_jabon_" + i)
                    .estado("Disponible")
                    .categorias(new HashSet<>(Set.of(individuales)))
                    .build();

            productoRepositorio.save(jabon);
        }
        
        // Aquí podrías añadir cajas de jabones
        Producto cajaDeJabones = Producto.builder()
                .nombre("Caja de Jabones Deluxe")
                .precio(29.99)
                .descripcion("Una caja elegante con una selección de nuestros mejores jabones.")
                .stock(20)
                .imagenUrl("url_a_imagen_caja_jabones")
                .estado("Disponible")
                .categorias(new HashSet<>(Set.of(cajas)))
                .build();

        productoRepositorio.save(cajaDeJabones);
        // Añade más productos según sea necesario
    }
}

