package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}






/*
 * JPA Repository do spring-data-JPA que é um sub-framework do ecossitema spring, 
 * é a camada mais em baixo da arquitetura;
 * o UserRepository é o repository responsável por fazer operações com entidade User;
 * pra a gente criar um UserRepository reutilizando o JPA-Repository basta  ele extender JpaRepository<User, Long>;
 * JPARepository é uma interface;
 * Não precisa criar a implementações da interface pq o spring-data-JPA ele já tem uma implementação padrão;
 * @Repository não é necessário pq a interface já está herdando do JpaRepository, logo ele já está registrado como componente do spring (opcional);  
 */