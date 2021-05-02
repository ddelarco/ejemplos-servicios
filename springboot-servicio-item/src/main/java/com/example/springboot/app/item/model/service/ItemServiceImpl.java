package com.example.springboot.app.item.model.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.app.item.model.Item;
import com.example.springboot.app.item.model.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
//		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));
		
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
//		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
		Producto producto = clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
		ResponseEntity<Producto> response = clienteRest.exchange("http://servicio-productos/crear", HttpMethod.POST, body, Producto.class);
		Producto productoResponse = response.getBody();
		return productoResponse;
	}

	@Override
	public Producto update(Producto producto, Long id) {
		HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		ResponseEntity<Producto> response = clienteRest.exchange("http://servicio-productos/editar/{id}",
				HttpMethod.PUT, body, Producto.class, pathVariables);
		return response.getBody();
	}

	@Override
	public void delete(Long id) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		clienteRest.delete("http://servicio-productos/eliminar/{id}", pathVariables);
	}

}
