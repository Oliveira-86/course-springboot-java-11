package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController  
@RequestMapping(value = "/users") 
public class UserResource { 
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "maria", "maria@gmail.cm", "9999999", "123456");
		return ResponseEntity.ok().body(u);
	}
}




/* 
 * @RestController Essa classe é um recurso web que é implemetado por um controlador rest;
 * @RequestMapping(value = "/users") //Determina o caminho para o recurso, um "nome";
 * @GetMapping //metodo que é um end point para acessar os usuários;	
 */

