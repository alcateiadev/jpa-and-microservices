package com.br.alcateiadev.jpa.jpaandmicroservice;

import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaEntity;
import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaFilhosEntity;
import com.br.alcateiadev.jpa.jpaandmicroservice.service.AlterarFamiliaService;
import com.br.alcateiadev.jpa.jpaandmicroservice.service.DeletarFamiliaService;
import com.br.alcateiadev.jpa.jpaandmicroservice.service.IncluirFamiliaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Log4j2
public class JpaAndMicroserviceApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaAndMicroserviceApplication.class, args);
    }

    @Autowired
    private IncluirFamiliaService incluirFamiliaService;

    @Autowired
    private AlterarFamiliaService alterarFamiliaService;

    @Autowired
    private DeletarFamiliaService deletarFamiliaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FamiliaEntity familia = FamiliaEntity
                .builder()
                .nome("Familia Vieira")
                .build();

        List<FamiliaFilhosEntity> listFilhos = new ArrayList<>();

        listFilhos.add(FamiliaFilhosEntity
                .builder()
                .nome("Filho 1")
                .familia(familia)
                .build()
        );

        listFilhos.add(FamiliaFilhosEntity
                .builder()
                .nome("Filho 2")
                .familia(familia)
                .build()
        );

        listFilhos.add(FamiliaFilhosEntity
                .builder()
                .nome("Filho 3")
                .familia(familia)
                .build()
        );

        familia.setFilhos(listFilhos);

        incluirFamiliaService.execute(familia);

        FamiliaEntity familiaAlteracao = FamiliaEntity
                .builder()
                .id(familia.getId())
                .nome("Familia Vieira novo")
                .build();

        alterarFamiliaService.execute(familiaAlteracao);

        deletarFamiliaService.execute(familiaAlteracao.getId());
    }
}
