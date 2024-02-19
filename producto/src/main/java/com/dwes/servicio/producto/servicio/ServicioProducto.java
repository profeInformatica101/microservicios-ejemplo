package com.dwes.servicio.producto.servicio;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwes.servicio.producto.entidad.Categoria;
import com.dwes.servicio.producto.entidad.Producto;
import com.dwes.servicio.producto.expcecion.ProductoNotFoundException;
import com.dwes.servicio.producto.repositorio.CategoriaRepositorio;
import com.dwes.servicio.producto.repositorio.ProductoRepositorio;

@Service
public class ServicioProducto {

@Autowired
ProductoRepositorio repositorioProducto;

@Autowired
CategoriaRepositorio categoriaRepositorio;
	
	public List<Producto> obtenerProductos(){

		return repositorioProducto.findAll();
		
	}

	public Producto buscarPorID(Long id) {
		return repositorioProducto.findById(id).orElseThrow(() -> new ProductoNotFoundException("Producto con ID " + id + " no encontrado"));
	}
	



}
