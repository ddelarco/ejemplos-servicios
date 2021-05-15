package com.example.springboot.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.app.usuarios.commons.models.entity.Usuario;

@FeignClient(name = "servicio-usuarios")
public interface UsuarioFeignClient {

	 @GetMapping("/usuarios/search/buscar_username")
	 public Usuario findByUsername(@RequestParam String username);
}
