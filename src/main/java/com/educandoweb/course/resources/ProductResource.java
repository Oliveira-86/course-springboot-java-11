package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> finById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

/*
 * 
 * @RestController - Essa classe é um recurso web que é implementado por um
 * controlador rest;
 * 
 * @RequestMapping(value = "/users") --> Determina o caminho para o recurso, um
 * "nome";
 * 
 * @GetMapping --> metodo que é um end point para acessar os usuários;
 * 
 * @Autowride --> Necessário cria um dependência para o Service;
 * 
 * @GetMapping(value = "/{id}") --> passar o valor da url e que a requisição
 * seja aceita;
 * 
 * @PathVariable --> Annotation, serve para que o spring aceite o parametro(id)
 * e considera-lo para chegar ate url "/{id}"
 */
