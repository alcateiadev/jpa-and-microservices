package com.br.alcateiadev.jpa.jpaandmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "nomes_tabela")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NomeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nomes_sequence")
    private Long id;

    @Column(name = "nome", length = 500, nullable = false)
    private String nome;

    @Column(name = "sobrenome", length = 500, nullable = true)
    private String sobrenome;

    @Column(name = "idade", nullable = false)
    private Long idade;

    @Column(name = "renda", nullable = true, scale = 12, precision = 2)
    private Float renda;
}
