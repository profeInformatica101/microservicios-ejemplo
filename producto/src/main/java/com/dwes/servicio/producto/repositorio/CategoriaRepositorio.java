package com.dwes.servicio.producto.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwes.servicio.producto.entidad.Categoria;



@Repository
public interface CategoriaRepositorio  extends JpaRepository<Categoria, Long>{

}
