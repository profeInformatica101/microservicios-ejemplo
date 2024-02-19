package com.dwes.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dwes.entidad.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    // Método para buscar un carrito por el ID del cliente
    Optional<Carrito> findByClienteId(Long clienteId);

}