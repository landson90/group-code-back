package com.group.api.service;

import com.group.api.dto.MembroRequestDto;
import com.group.api.dto.MembrosDto;
import com.group.api.exceptions.MembrosException;
import com.group.api.model.Membros;
import com.group.api.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembrosService {

    private MembroRepository membroRepository;
    private  PessoaService pessoaService;
    private  ProjetoService projetoService;

    @Autowired
    public MembrosService(MembroRepository membroRepository, PessoaService pessoaService, ProjetoService projetoService) {
        this.membroRepository = membroRepository;
        this.pessoaService = pessoaService;
        this.projetoService = projetoService;
    }

    public MembrosDto salvarMembros(MembroRequestDto request) {
        var pessoa =  pessoaService.obterPessoa(request.getPessoaId());
        var projeto = projetoService.obterProjeto(request.getProjetoId());
        if(!pessoa.getCargoEnum().getDescricao().equals("FUCIONARIO")) {
            throw new MembrosException("Voce não pode ser cadastro nesse projeto");
        }

        var membro = Membros.builder()
                .pessoa(pessoa)
                .projeto(projeto)
                .build();

        var membroSalvo = membroRepository.save(membro);

        return MembrosDto
                .builder()
                .cargo(membroSalvo.getPessoa().getCargoEnum().getDescricao())
                .nome(membroSalvo.getPessoa().getNome())
                .build();
    }
}
