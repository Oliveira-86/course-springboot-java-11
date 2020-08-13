package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}






/* 
 * JPA Repository do spring-data-JPA que é um sub-framework do ecossitema spring, 
 * é a camada mais em baixo da arquitetura;
 * o UserRepository é o repository responsável por fazer operações com entidade User;
 * pra a gente criar um UserRepository reutilizando o JPARepository basta  ele extender JpaRepository<User, Long>;
 * JPARepository é uma interface;
 * Não precisa criar a implementações da interface pq o spring-data-JPA ele já tem uma implementação padrão  
 */