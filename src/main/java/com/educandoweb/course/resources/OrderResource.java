package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

@RestController  
@RequestMapping(value = "/orders") 
public class OrderResource { 
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> finById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}




/* 
 * 
 * @RestController - Essa classe é um recurso web que é implementado por um controlador rest;
 * @RequestMapping(value = "/users") --> Determina o caminho para o recurso, um "nome";
 * @GetMapping --> metodo que é um end point para acessar os usuários;
 * @Autowride --> Necessário cria um dependência para o Service;
 * @GetMapping(value = "/{id}") --> passar o valor da url e que a requisição seja aceita;
 * @PathVariable --> Annotation, serve para que o spring aceite o parametro(id) e considera-lo para chegar ate url "/{id}"	
 */

