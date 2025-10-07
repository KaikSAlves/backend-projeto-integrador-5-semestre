package com.senac.backend.pi.backend_projeto_integrador.controller;

import com.senac.backend.pi.backend_projeto_integrador.model.Cliente;
import com.senac.backend.pi.backend_projeto_integrador.model.Funcionario;
import com.senac.backend.pi.backend_projeto_integrador.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @PostMapping
    public ResponseEntity<Cliente> create (@RequestBody Cliente cliente){

        if(cliente != null){
            cliente = service.create(cliente);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(cliente.getId()).toUri();

            return ResponseEntity.created(uri).body(cliente);
        }

        return ResponseEntity.badRequest().body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){

        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente cliente = service.findById(id);

        if(cliente == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> update (@PathVariable Integer id, @RequestBody Cliente cliente)
    {
        if(cliente == null) return ResponseEntity.badRequest().build();

        if(!service.existsInDatabase(id)) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(service.update(cliente, id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        if(!service.existsInDatabase(id)) return ResponseEntity.notFound().build();

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
