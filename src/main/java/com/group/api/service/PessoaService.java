package com.group.api.service;

import com.group.api.dto.PessoaDto;
import com.group.api.dto.mapper.PessoaMapper;
import com.group.api.exceptions.ObjetoNaoEncontradoException;
import com.group.api.model.Pessoa;
import com.group.api.repository.PessoaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaMapper mapper;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, PessoaMapper mapper) {
        this.pessoaRepository = pessoaRepository;
        this.mapper = mapper;
    }

    
    

    public List<PessoaDto> listarPessoas() {
        var listaDePessoas = pessoaRepository.findAll();
        return mapper.toCollectionModel(listaDePessoas);
    }

    public PessoaDto salvar(PessoaDto dto) {
        var pessoaModel = mapper.toModelPesssoa(dto);
        var pessoaSalva = pessoaRepository.save(pessoaModel);
        return mapper.toModelPessoaDto(pessoaSalva);
    }

    public PessoaDto vizualizarPessoa(Long id) {
        var pessoa = validarPessoa(id);
        return mapper.toModelPessoaDto(pessoa);
    }

    public Pessoa obterPessoa(Long id) {
        return validarPessoa(id);
    }
    private Pessoa validarPessoa(Long id) {
        Optional<Pessoa> product = this.pessoaRepository.findById(id);
        Pessoa pessoa = product.orElseThrow(() -> new ObjetoNaoEncontradoException(
                "Nao temos produto associado para esse código  " + id
        ));
        return pessoa;
    }
}
