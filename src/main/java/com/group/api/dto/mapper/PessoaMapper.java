package com.group.api.dto.mapper;

import com.group.api.dto.PessoaDto;
import com.group.api.model.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PessoaDto toModelPessoaDto(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaDto.class);
    }

    public Pessoa toModelPesssoa(PessoaDto pessoaDto) {
        return modelMapper.map(pessoaDto, Pessoa.class);
    }

    public List<PessoaDto> toCollectionModel(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(p -> toModelPessoaDto(p))
                .collect(Collectors.toList());
    }

}

