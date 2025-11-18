package com.senac.backend.pi.backend_projeto_integrador.repository;


import com.senac.backend.pi.backend_projeto_integrador.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByClienteId(Integer clienteId);
}
