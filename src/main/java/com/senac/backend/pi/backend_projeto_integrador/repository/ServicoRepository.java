package com.senac.backend.pi.backend_projeto_integrador.repository;

import com.senac.backend.pi.backend_projeto_integrador.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    List<Servico> findByAtivoTrue();
}
