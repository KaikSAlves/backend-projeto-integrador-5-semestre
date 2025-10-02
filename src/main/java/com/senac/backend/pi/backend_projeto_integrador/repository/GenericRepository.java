package com.senac.backend.pi.backend_projeto_integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.backend.pi.backend_projeto_integrador.model.EntidadeBase;

public interface GenericRepository<T> extends JpaRepository<T, Integer> {
    
}
