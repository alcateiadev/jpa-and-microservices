package com.br.alcateiadev.jpa.jpaandmicroservice.service.familia;

import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaEntity;
import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaFilhosEntity;
import com.br.alcateiadev.jpa.jpaandmicroservice.repository.FamiliaRepository;
import com.br.alcateiadev.jpa.jpaandmicroservice.service.filho.IncluirFilhosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IncluirFamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private IncluirFilhosService incluirFilhosService;

    @Transactional
    public void execute(FamiliaEntity familiaEntity){
        if( familiaEntity.getFilhos() == null ){
            throw new RuntimeException("Filhos são obrigatórios");
        }

        List<FamiliaFilhosEntity> filhos = familiaEntity.getFilhos();

        familiaRepository.save(familiaEntity);

        incluirFilhosService.execute(filhos, familiaEntity);
    }
}
