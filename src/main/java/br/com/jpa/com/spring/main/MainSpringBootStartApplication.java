package br.com.jpa.com.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.jpa.com.spring.controller.UsuariosResource;

@SpringBootApplication
@EnableJpaRepositories("br.com.jpa.com.spring.dao")
@EntityScan("br.com.jpa.com.spring.model")
@ComponentScan(basePackageClasses = UsuariosResource.class)
public class MainSpringBootStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainSpringBootStartApplication.class, args);
	}
}
