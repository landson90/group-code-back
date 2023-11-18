package com.group.api.controller;

import com.group.api.dto.PessoaDto;
import com.group.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> listarPessoas() {
        var response =  pessoaService.listarPessoas();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<PessoaDto> salvar(@RequestBody PessoaDto dto) {
        var response =  pessoaService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> vizualizarPessoa(@RequestParam Long id) {
        var response =  pessoaService.vizualizarPessoa(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
