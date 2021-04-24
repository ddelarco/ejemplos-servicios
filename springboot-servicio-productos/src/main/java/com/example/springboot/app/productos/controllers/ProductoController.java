package com.example.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.app.productos.models.entity.Producto;
import com.example.springboot.app.productos.models.services.IProductoServices;

//Indicamos que es un controlador de tipo Rest
@RestController
public class ProductoController {

	@Autowired
//	private Environment env;

	@Value("${server.port}")
	private Integer port;
		
	@Autowired
	private IProductoServices productoServices;
	
	@GetMapping("/listar")
	public List<Producto> listar() {
		return productoServices.findAll().stream().map(producto -> {
//			producto.setPort(env.getProperty("local.server.port"))
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) throws Exception {
		Producto producto = productoServices.findById(id);
//		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		
		boolean ok = false;
		if (ok == false) {
			throw new Exception("No se pudo cargar el producto");
		}
		return producto;
	}
}
