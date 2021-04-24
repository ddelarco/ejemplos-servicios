package com.example.springboot.app.item;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Permite crear objetos
@Configuration
public class AppConfig {

	//es un cliente para acceder a otros servicios
	@Bean("clienteRest")
	//@LoadBalanced utilizara el balanceo Ribbon
	@LoadBalanced
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
