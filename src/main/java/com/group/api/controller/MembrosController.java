package com.group.api.controller;


import com.group.api.dto.MembroRequestDto;
import com.group.api.dto.MembrosDto;
import com.group.api.service.MembrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/membros")
public class MembrosController {


    private  MembrosService service;


    @Autowired
    public MembrosController(MembrosService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<MembrosDto> salvarMembros(@RequestBody MembroRequestDto request) {
        var response = service.salvarMembros(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
