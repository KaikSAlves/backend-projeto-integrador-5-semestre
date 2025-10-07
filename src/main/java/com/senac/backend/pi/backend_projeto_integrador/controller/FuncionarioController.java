package com.senac.backend.pi.backend_projeto_integrador.controller;


import com.senac.backend.pi.backend_projeto_integrador.model.Funcionario;
import com.senac.backend.pi.backend_projeto_integrador.model.Usuario;
import com.senac.backend.pi.backend_projeto_integrador.services.FuncionarioService;
import com.senac.backend.pi.backend_projeto_integrador.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;


    @PostMapping
    public ResponseEntity<Funcionario> create (@RequestBody Funcionario funcionario){

        if(funcionario != null){
            funcionario = service.create(funcionario);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(funcionario.getId()).toUri();

            return ResponseEntity.created(uri).body(funcionario);
        }

        return ResponseEntity.badRequest().body(funcionario);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll(){

        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Integer id){
        Funcionario funcionario = service.findById(id);

        if(funcionario == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(funcionario);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Funcionario> update (@PathVariable Integer id, @RequestBody Funcionario funcionario)
    {
        if(funcionario == null) return ResponseEntity.badRequest().build();

        if(!service.existsInDatabase(id)) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(service.update(funcionario, id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        if(!service.existsInDatabase(id)) return ResponseEntity.notFound().build();

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
