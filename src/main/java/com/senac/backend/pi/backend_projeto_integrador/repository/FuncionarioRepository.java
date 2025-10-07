package com.senac.backend.pi.backend_projeto_integrador.repository;

import com.senac.backend.pi.backend_projeto_integrador.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
