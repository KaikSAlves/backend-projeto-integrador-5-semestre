package com.senac.backend.pi.backend_projeto_integrador.controller;


import com.senac.backend.pi.backend_projeto_integrador.model.Usuario;
import com.senac.backend.pi.backend_projeto_integrador.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @PostMapping
    public ResponseEntity<Usuario> create (@RequestBody Usuario usuario){

        if(usuario != null){
            usuario = service.create(usuario);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(usuario.getId()).toUri();

            return ResponseEntity.created(uri).body(usuario);
        }

        return ResponseEntity.badRequest().body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){

        return ResponseEntity.ok().body(service.findAll());
    }

}
