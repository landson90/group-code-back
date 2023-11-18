package com.group.api.dto;

import com.group.api.enums.CargoEnum;
import com.group.api.model.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {

    private Long id;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private boolean funcionario;
    private String cargoEnum;



}
