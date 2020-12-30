package com.br.alcateiadev.jpa.jpaandmicroservice.service;

import com.br.alcateiadev.jpa.jpaandmicroservice.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DeletarFamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Transactional
    public void execute(Long id){
        familiaRepository.deleteById(id);
    }

}
