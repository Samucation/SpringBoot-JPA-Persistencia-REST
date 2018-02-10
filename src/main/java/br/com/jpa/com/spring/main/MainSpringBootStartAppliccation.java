package br.com.jpa.com.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.jpa.com.spring.dao")
@EntityScan("br.com.jpa.com.spring.model")
public class MainSpringBootStartAppliccation {

	public static void main(String[] args) {
		SpringApplication.run(MainSpringBootStartAppliccation.class, args);
	}
}
