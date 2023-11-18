package com.group.api.dto.mapper;


import com.group.api.dto.ProjetoDto;
import com.group.api.dto.ProjetoRequestDto;
import com.group.api.model.Pessoa;
import com.group.api.model.Projeto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjetoMapper {

    @Autowired
    private ModelMapper modelMapper;


    public ProjetoDto toModelProjetoDto(Projeto projeto) {
        return modelMapper.map(projeto, ProjetoDto.class);
    }

    public Projeto toModelPesssoa(ProjetoDto pessoaDto) {
        return modelMapper.map(pessoaDto, Projeto.class);
    }

    public List<ProjetoDto> toCollectionModel(List<Projeto> projetos) {
        return projetos.stream()
                .map(p -> toModelProjetoDto(p))
                .collect(Collectors.toList());
    }

    public Projeto toRequestProjeto(ProjetoRequestDto request, Pessoa pessoa) {
        return Projeto.builder()
                .nome(request.getNome())
                .dataInicio(request.getDataInicio())
                .dataFim(request.getDataFim())
                .dataPrevisaoFim(request.getDataPrevisaoFim())
                .descricao(request.getDescricao())
                .status(request.getStatus())
                .orcamento(request.getOrcamento())
                .risco(request.getRisco())
                .pessoa(pessoa)
                .build();
    }
}
