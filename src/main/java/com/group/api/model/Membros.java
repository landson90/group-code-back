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
    @Column(name = "membro_id")
    private Long membroId;



    @ManyToOne
    @JoinColumn(name = "idprojeto")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;
}
