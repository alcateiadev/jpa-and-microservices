package com.br.alcateiadev.jpa.jpaandmicroservice.service.filho;

import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaEntity;
import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaFilhosEntity;
import com.br.alcateiadev.jpa.jpaandmicroservice.repository.FamiliaFilhosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IncluirFilhosService {

    @Autowired
    private FamiliaFilhosRepository familiaFilhosRepository;

    public void execute(List<FamiliaFilhosEntity> filhos, FamiliaEntity familia){

        filhos.stream().forEach(filho -> {
            filho.setFamilia(familia);
            familiaFilhosRepository.save(filho);
        });

    }
}
