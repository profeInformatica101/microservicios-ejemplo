package com.dwes.servicio.producto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwes.servicio.producto.entidad.Categoria;
import com.dwes.servicio.producto.entidad.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{
    List<Producto> findByCategorias(Categoria categoria);
    List<Producto> findByCategoriasNombre(String nombreCategoria);
    }
