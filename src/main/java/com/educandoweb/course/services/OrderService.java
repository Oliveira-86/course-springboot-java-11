package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}

/*
 * Service Layer é uma camada intermediária de serviço que serve para
 * implementar as regras de negócio, orquestração de repository e etc, são
 * muitas operações que se fosse colocado tudo no controlador ele ia ficar muito
 * carregado com regras de negócio, então serve para separar as
 * responsabilidades; O controlador fica fazendo apenas o "meio de campo" entre
 * as interações do usuário na aplicação e as regras de negócio, ou seja, o
 * contralador fica mais enxuto; Tem algumas desvantagens, exemplo: tem algumas
 * operações onde a camada de serviço vai repassar apenas algumas chamadas do
 * controlador("recuperar um usuário por Id"); Para realizar um operação de
 * busca de todos usuários ou por Id deve usar a dependencia do Repository;
 * 
 * Component registration --> Para injeta a depedência de uma classe ela precisa
 * estar registrada no mecanismo de injeçao de dependencia do framework;
 * 
 * @Service --> Para essa que essa classe(OrderService) funcione na OrderResource
 * ela tem que se registrar no componente do spring precisamos registrar essa
 * annotation;
 */