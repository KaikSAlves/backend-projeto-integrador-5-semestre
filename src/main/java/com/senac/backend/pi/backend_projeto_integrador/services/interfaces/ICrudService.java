package com.senac.backend.pi.backend_projeto_integrador.services.interfaces;

import com.senac.backend.pi.backend_projeto_integrador.model.Usuario;

import java.util.List;

public interface ICrudService<T> {

    T create(T obj);

    List<T> findAll();

    T findById(Integer id);

    void delete(Integer id);

    T update(T obj, Integer id);

    boolean existsInDatabase(Integer id);
}
