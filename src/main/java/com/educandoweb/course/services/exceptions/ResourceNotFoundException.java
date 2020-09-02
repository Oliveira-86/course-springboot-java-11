package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super ("Resource not found. Id " + id);
	}

}



/*
 * Classe criada para gerar um tratamento de exceção personalizada do service layer, sendo capaz de lançar a propria excceção e nao deixar estourar uma do sistema;
 * 
 * extends RuntimeException { -> Essa classe é uma subclasse do RuntimeException do java q é a exceção que o compilador nao obriga a tratar}  
 * 
 */
