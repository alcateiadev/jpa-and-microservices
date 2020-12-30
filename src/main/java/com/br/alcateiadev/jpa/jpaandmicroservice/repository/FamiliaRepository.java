package com.br.alcateiadev.jpa.jpaandmicroservice.repository;

import com.br.alcateiadev.jpa.jpaandmicroservice.entity.FamiliaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FamiliaRepository extends CrudRepository<FamiliaEntity, Long> {

    @Query(value = "select nome from familia_tabela where id = ?1", nativeQuery = true)
    String findNameNativeById(Long id);

    @Query("select new FamiliaEntity(nome) from FamiliaEntity where id = ?1 ")
    FamiliaEntity findNameObjById(Long id);

}
