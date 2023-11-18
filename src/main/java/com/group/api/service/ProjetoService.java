package com.group.api.service;

import com.group.api.dto.ProjetoDto;
import com.group.api.dto.ProjetoRequestDto;
import com.group.api.dto.mapper.ProjetoMapper;
import com.group.api.exceptions.ObjetoNaoEncontradoException;
import com.group.api.exceptions.ProjetoNaoPodeSerApagadoException;
import com.group.api.model.Pessoa;
import com.group.api.model.Projeto;
import com.group.api.repository.ProjetoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    private ProjetoRepository projetoRepository;
    private PessoaService pessoaService;
    private ProjetoMapper mapper;
    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository, PessoaService pessoaService, ProjetoMapper mapper) {
        this.projetoRepository = projetoRepository;
        this.pessoaService = pessoaService;
        this.mapper = mapper;
    }

    public List<ProjetoDto> listarProjetos() {

        var projetos =  projetoRepository.findAll();
        return mapper.toCollectionModel(projetos);

    }

    public ProjetoDto salvarProjeto(ProjetoRequestDto projetoRequestDto) {
        var pessoa = pessoaService.obterPessoa(projetoRequestDto.getPessoaId());
        var projeto = mapper.toRequestProjeto(projetoRequestDto,  pessoa);
        var projetoSalvo = projetoRepository.save(projeto);
        return mapper.toModelProjetoDto(projetoSalvo);
    }

    public void editarProjeto(ProjetoRequestDto request, Long id) {
        var projeto = validarPessoa(id);
        BeanUtils.copyProperties(request, projeto, "id", "dataInicio", "dataFim");
        this.projetoRepository.save(projeto);

    }

    private Projeto validarPessoa(Long id) {
        Optional<Projeto> product = this.projetoRepository.findById(id);
        Projeto projeto = product.orElseThrow(() -> new ObjetoNaoEncontradoException(
                "Nao temos projeto associado para esse código  " + id
        ));
        return projeto;
    }

    public void apagarProjeto(Long id) {
        var projeto = validarPessoa(id);
        if(projeto.getStatus().getDescricao().equals("INICIADO") ||
                projeto.getStatus().getDescricao().equals("EM_ANDAMENTO") ||
                projeto.getStatus().getDescricao().equals("ENCERRADO")) {
            throw new ProjetoNaoPodeSerApagadoException("Não poder apagar projeto");
        }
        projetoRepository.deleteById(id);

    }
}
