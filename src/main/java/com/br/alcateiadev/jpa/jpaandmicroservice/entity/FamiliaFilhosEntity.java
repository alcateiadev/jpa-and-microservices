package com.br.alcateiadev.jpa.jpaandmicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "filhos_tabela")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FamiliaFilhosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filhos_sequence")
    private Long id;

    @Column(name = "nome", length = 500)
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "familia_id", nullable = false)
    private FamiliaEntity familia;
}
