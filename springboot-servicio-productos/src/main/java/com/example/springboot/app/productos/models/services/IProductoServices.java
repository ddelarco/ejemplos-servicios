package com.example.springboot.app.productos.models.services;

import java.util.List;

import com.example.springboot.app.productos.models.entity.Producto;

public interface IProductoServices {

	public List<Producto> findAll();
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);
}
