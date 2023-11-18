package com.group.api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "tb_membros")
public class Membros {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprojeto")
    private Long idProjeto;

    @Column(name = "idpessoa")
    private Long idPessoa;

    @ManyToOne
    @JoinColumn(name = "idprojeto", insertable = false, updatable = false)
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "idpessoa", insertable = false, updatable = false)
    private Pessoa pessoa;
}
