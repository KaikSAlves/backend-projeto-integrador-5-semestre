package com.senac.backend.pi.backend_projeto_integrador.services;

import com.senac.backend.pi.backend_projeto_integrador.model.Funcionario;
import com.senac.backend.pi.backend_projeto_integrador.model.Usuario;
import com.senac.backend.pi.backend_projeto_integrador.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository rep;

    public Funcionario create(Funcionario funcionario){
        return rep.save(funcionario);
    }

    public List<Funcionario> findAll(){
        return rep.findAll();
    }

    public Funcionario findById(Integer id){
        return rep.findById(id).orElse(null);
    }

    public void delete(Integer id){

        Funcionario funcionario = findById(id);

        if(funcionario != null){
            rep.delete(funcionario);
        }

    }

    public Funcionario update(Funcionario funcionario, Integer id){
        try{
            Funcionario ent = rep.getReferenceById(id);
            updateData(ent, funcionario);
            return rep.save(ent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existsInDatabase(Integer id){
        return rep.existsById(id);
    }

    private void updateData(Funcionario ent, Funcionario obj) {
        ent.setEmail(obj.getEmail());
        ent.setEmail(obj.getEmail());
        ent.setTelefone(obj.getTelefone());
    }
}
