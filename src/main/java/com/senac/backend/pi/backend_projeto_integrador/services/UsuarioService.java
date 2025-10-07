package com.senac.backend.pi.backend_projeto_integrador.services;

import com.senac.backend.pi.backend_projeto_integrador.model.Usuario;
import com.senac.backend.pi.backend_projeto_integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository rep;

    public Usuario create(Usuario usuario){
        return rep.save(usuario);
    }

    public List<Usuario> findAll(){
        return rep.findAll();
    }

    public Usuario findById(Integer id){
        return rep.findById(id).orElse(null);
    }

    public void delete(Integer id){

        Usuario usuario = findById(id);

        if(usuario != null){
            rep.delete(usuario);
        }

    }

    public Usuario update(Usuario usuario, Integer id){
        try{
            Usuario ent = rep.getReferenceById(id);
            updateData(ent, usuario);
            return rep.save(ent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existsInDatabase(Integer id){
        return rep.existsById(id);
    }

    private void updateData(Usuario ent, Usuario obj) {
        ent.setEmail(obj.getEmail());
        ent.setSenha(obj.getSenha());
        ent.setNome(obj.getNome());
    }



}
