### Projeto web services com Spring Boot e JPA / Hibernate

## Objetivos
- Criar projeto Spring Boot Java
- Implementar modelo de domínio
- Estruturar camadas lógicas: resource, service, repository
- Configurar banco de dados de teste (H2)
- Povoar o banco de dados
- CRUD - Create, Retrieve, Update, Delete
- Tratamento de exceções

## Tecnologias
- Spring Boot
- Apache Tomcat
- Maven
- H2
- Postman
- PostgreSQL
- Heroku

## Algoritmos
### User entity and resource

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "maria", "maria@gmail.cm", "9999999", "123456");
		return ResponseEntity.ok().body(u);
	}

Método end point para  acesso ao usuário.

### H2 database, test profile, JPA

	  <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

Utilização do Maven para gerenciamento das dependências.

	spring.datasource.url=jdbc:h2:mem:testdb
	spring.datasource.username=sa
	spring.datasource.password=

	spring.h2.console.enabled=true
	spring.h2.console.path=/h2-console

	spring.jpa.show-sql=true
	spring.jpa.properties.hibernate.format_sql=true

Ultilização do H2 para teste de armazenamentos de dados em memória de forma rápida e prática.

### JPA repository, dependency injection, database seeding
	package com.educandoweb.course.repositories;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.educandoweb.course.entities.User;

	public interface UserRepository extends JpaRepository<User, Long> {

	}

- JPA Repository do spring-data-JPA que é um sub-framework do ecossitema spring, é a camada mais em baixo da arquitetura.



	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		userRepository.saveAll(Arrays.asList(u1, u2));

	}

A classe de config serve temporariamente para o data base seeding, ou seja, é pra popular o banco de dados com alguns objetos,assim podemos fazer teste de requisição no Postman(end point). 
Para acessar e depositar dados a classe que faz isso é o Repository, então nesse momento tem primeiro caso de injeçao de dependência.

#### Conclusão
Nesse projeto o foco foi a realização de boas práticas de engenharia de software no backend com desenvolvimento em camadas(serviço, repository e domínio) com os controladores REST API e os tratamentos de exceções.  

### End
 

