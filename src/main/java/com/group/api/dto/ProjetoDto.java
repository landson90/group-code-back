package com.group.api.dto;


import com.group.api.enums.NivelRiscoEnum;
import com.group.api.enums.StatusProjetoEnum;
import com.group.api.model.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDto {

    private Long id;
    private String nome;
    private Date dataInicio;
    private Date dataPrevisaoFim;
    private Date dataFim;
    private String descricao;
    private StatusProjetoEnum status;
    private Float orcamento;
    private String risco;
    private Pessoa pessoa;
}
