package com.senac.backend.pi.backend_projeto_integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.senac.backend.pi.backend_projeto_integrador.model.EntidadeBase;
import com.senac.backend.pi.backend_projeto_integrador.model.Usuario;
import com.senac.backend.pi.backend_projeto_integrador.repository.GenericRepository;

public class GenericServiceImplementation<T extends EntidadeBase>{
    
    @Autowired
    private GenericRepository rep;

    public T Create(T obj) {
        return (T) rep.save(obj);
    }

    public List<T> FindAll() {
        return rep.findAll();
        
    }

    public T FindById(int id) {
       return (T) rep.findById(id).orElse(null);
    }

    public T Update(T Obj) {
      T objAntigo = (T) rep.findById(Obj.getId()).orElse(null);

      if(objAntigo != null){
        return (T) rep.save(objAntigo);
      }

      return null;
    }

    public void Delete(int id) {
        rep.deleteById(id);
    }


}
