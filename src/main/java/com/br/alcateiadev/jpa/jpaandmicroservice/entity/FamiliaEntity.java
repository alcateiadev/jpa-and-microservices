package com.br.alcateiadev.jpa.jpaandmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "familia_tabela")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FamiliaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "familia_sequence")
    private Long id;

    @Column(name = "nome", length = 500)
    private String nome;
}
