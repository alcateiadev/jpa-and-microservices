package com.br.alcateiadev.jpa.jpaandmicroservice;

import com.br.alcateiadev.jpa.jpaandmicroservice.entity.NomeEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootApplication
@Log4j2
public class JpaAndMicroserviceApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaAndMicroserviceApplication.class, args);
	}

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {

		log.info("Gravando nome....");
		NomeEntity nome = NomeEntity
				.builder()
				.nome("Marcelo")
				.sobrenome("Vieira")
				.idade(39L)
				.renda(1000F)
				.build();

		entityManager.persist(nome);

		nome = NomeEntity
				.builder()
				.nome("Marcelo 2")
				.idade(39L)
				.build();

		entityManager.persist(nome);

		log.info("Nome 2 gravado");
	}
}
