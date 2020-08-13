package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}

}










/*
 * A classe config é uma classe auxiliar que faz configurações na aplicações;
 * A Classe "TestConfig" é classe configuração especifica para o perfil de test;
 * @Configuration --> pra falar pro spring que essa é um classe especifica de configuração;
 * @Profile("test") --> indica a class que é um configuração específica pra test;
 * A classe de config serve temporariamente para o data base seeding, ou seja, é pra ppopular o banco de dados com alguns obj  e para acessar e depositar dados a classe que faz isso é o Repository, então nesse momento tem primeiro caso de injeçao de dependência;
 * Em POO qnd um serviço depende do outro essa dependência tem que ser fraca, desacoplada(manualmente por construtor, método set e etc..);
 * O framework tem um mecanismo de dependência implícito é automático, no spring declaramos a dependência com atributo e para que o spring consiga resolver essa dependência e associar a instância do UserRepository no testConfig devemos colocar o anotation "@Autowired" 
 * Ao implementar o "CommandLineRunner" exucuta tud que estiver em seu metoo quando o programa for iniciado;
 * Para salvar os obj no BD em forma de lista usamos "userRepository.saveAll(Arrays.asList(u1, u2));";
 *   
 */
