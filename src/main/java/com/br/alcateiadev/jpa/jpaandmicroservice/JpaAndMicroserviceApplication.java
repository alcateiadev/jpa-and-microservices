package com.br.alcateiadev.jpa.jpaandmicroservice;

import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaEntity;
import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaFilhosEntity;
import com.br.alcateiadev.jpa.jpaandmicroservice.entity.NomeEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

		FamiliaEntity familia = FamiliaEntity
				.builder()
				.nome("Familia Vieira")
				.build();

		List<FamiliaFilhosEntity> listFilhos = new ArrayList<>();

		listFilhos.add( FamiliaFilhosEntity
				.builder()
				.nome("Filho 1")
				.familia(familia)
				.build()
		);

		listFilhos.add( FamiliaFilhosEntity
				.builder()
				.nome("Filho 2")
				.familia(familia)
				.build()
		);

		listFilhos.add( FamiliaFilhosEntity
				.builder()
				.nome("Filho 3")
				.familia(familia)
				.build()
		);

		familia.setFilhos(listFilhos);

		entityManager.persist(familia);
	}
}
