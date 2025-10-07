package com.senac.backend.pi.backend_projeto_integrador.services;

import com.senac.backend.pi.backend_projeto_integrador.model.Usuario;
import com.senac.backend.pi.backend_projeto_integrador.repository.UsuarioRepository;
import com.senac.backend.pi.backend_projeto_integrador.services.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements ICrudService<Usuario> {

    @Autowired
    private UsuarioRepository rep;

    public Usuario create(Usuario usuario){

        if(usuario == null) return usuario;
        return rep.save(usuario);
    }

    public List<Usuario> findAll(){
        return rep.findAll();
    }

    public Usuario findById(Integer id){
        return rep.findById(id).orElse(null);
    }

    public void delete(Integer id){

        if(rep.existsById(id)){
            rep.deleteById(id);
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
