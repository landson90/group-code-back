package com.group.api.controller;

import com.group.api.dto.ProjetoDto;
import com.group.api.dto.ProjetoRequestDto;
import com.group.api.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/projetos")
public class ProjetoController {

    private ProjetoService projetoService;

    @Autowired
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping
    public ResponseEntity<List<ProjetoDto>> listarProjetos() {
        var response = projetoService.listarProjetos();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ProjetoDto> salvarProjeto(@RequestBody ProjetoRequestDto request) {
        var response = projetoService.salvarProjeto(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarProjeto(@RequestBody ProjetoRequestDto request, @PathVariable Long id) {
        projetoService.editarProjeto(request, id);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apgarProjeto(@PathVariable Long id) {
        projetoService.apagarProjeto(id);
        return ResponseEntity.status(201).build();
    }
}
