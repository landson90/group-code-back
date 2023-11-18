package com.group.api.repository;

import com.group.api.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
