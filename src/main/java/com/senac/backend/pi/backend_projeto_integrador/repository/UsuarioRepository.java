package com.senac.backend.pi.backend_projeto_integrador.repository;

import com.senac.backend.pi.backend_projeto_integrador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
