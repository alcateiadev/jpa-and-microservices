package com.br.alcateiadev.jpa.jpaandmicroservice.service.familia;

import com.br.alcateiadev.jpa.jpaandmicroservice.repository.FamiliaRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DeletarFamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Transactional
    public void execute(Long id) {
        familiaRepository.deleteById(id);
    }

}
