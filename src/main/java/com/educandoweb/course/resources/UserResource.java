package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController  
@RequestMapping(value = "/users") 
public class UserResource { 
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> finById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}




/* 
 * 
 * @RestController - Essa classe é um recurso web que é implementado por um controlador rest;
 * @RequestMapping(value = "/users") --> Determina o caminho para o recurso, um "nome";
 * @GetMapping --> metodo que é um end point para acessar os usuários;
 * @Autowride --> Necessário cria um dependência para o Service;
 * @GetMapping(value = "/{id}") --> passar o valor da url e que a requisição seja aceita;
 * @PathVariable --> Annotation, serve para que o spring aceite o parametro(id) e considera-lo para chegar ate url "/{id}";
 * 
 * @RequestBody --> Annotation Para que o json seja deserializado para objeto na hora da requisição;
 * 
 * URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri() --> Forma padrão do Spring Boot de gerar um endereço(location), é esperado a resposta "201 Created" no padrão HTTP. 	
 */

