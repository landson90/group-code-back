package com.group.api.service;

import com.group.api.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembrosService {

    private MembroRepository membroRepository;


    @Autowired
    public MembrosService(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }
}
