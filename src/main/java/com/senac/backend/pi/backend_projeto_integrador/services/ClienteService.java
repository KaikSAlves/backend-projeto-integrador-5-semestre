package com.senac.backend.pi.backend_projeto_integrador.services;

import com.senac.backend.pi.backend_projeto_integrador.model.Cliente;
import com.senac.backend.pi.backend_projeto_integrador.model.Funcionario;
import com.senac.backend.pi.backend_projeto_integrador.model.Usuario;
import com.senac.backend.pi.backend_projeto_integrador.repository.ClienteRespository;
import com.senac.backend.pi.backend_projeto_integrador.services.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ICrudService<Cliente> {

    @Autowired
    private ClienteRespository rep;


    @Override
    public Cliente create(Cliente cliente) {

        if(cliente == null) return cliente;

        return rep.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return rep.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        return rep.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {

        if(rep.existsById(id)){
            rep.deleteById(id);
        }
    }

    @Override
    public Cliente update(Cliente cliente, Integer id) {

        try{
            Cliente ent = rep.getReferenceById(id);
            updateData(ent, cliente);
            return rep.save(ent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsInDatabase(Integer id) {
        return rep.existsById(id);
    }

    public void updateData(Cliente ent, Cliente obj) {
        ent.setEmail(obj.getEmail());
        ent.setNome(obj.getNome());
        ent.setTelefone(obj.getTelefone());
    }
}
