package edu.bbte.bibliospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "edu.bbte.bibliospring.repository" })
public class BibliospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliospringApplication.class, args);
	}
}