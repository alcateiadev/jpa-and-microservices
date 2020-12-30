package com.br.alcateiadev.jpa.jpaandmicroservice.service;

import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaEntity;
import com.br.alcateiadev.jpa.jpaandmicroservice.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IncluirFamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Transactional
    public void execute(FamiliaEntity familiaEntity){
        if( familiaEntity.getFilhos() == null ){
            throw new RuntimeException("Filhos são obrigatórios");
        }
        familiaRepository.save(familiaEntity);
    }
}
