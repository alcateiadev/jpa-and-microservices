package com.br.alcateiadev.jpa.jpaandmicroservice.service.familia;

import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaEntity;
import com.br.alcateiadev.jpa.jpaandmicroservice.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AlterarFamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Transactional
    public void execute(FamiliaEntity familiaEntity) {

        Optional<FamiliaEntity> db = familiaRepository.findById(familiaEntity.getId());
        if (!db.isPresent()) {
            throw new RuntimeException("Familia não existe");
        }

        FamiliaEntity familiaDB = db.get();
        familiaDB.setNome(familiaEntity.getNome());

        familiaRepository.save(familiaDB);
    }

}
