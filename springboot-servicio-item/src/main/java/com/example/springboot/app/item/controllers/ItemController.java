package com.example.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.app.item.model.Item;
import com.example.springboot.app.item.model.service.ItemService;

@RestController
public class ItemController {

	//@Qualifier especifica cual se quiere seleccionar por defecto
	@Autowired
//	@Qualifier("serviceFeign")
	@Qualifier("serviceRestTemplate")
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
		return itemService.findById(id, cantidad);
	}
}
