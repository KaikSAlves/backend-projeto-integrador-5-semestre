package com.senac.backend.pi.backend_projeto_integrador.controller;


import com.senac.backend.pi.backend_projeto_integrador.model.Agendamento;
import com.senac.backend.pi.backend_projeto_integrador.model.Animal;
import com.senac.backend.pi.backend_projeto_integrador.services.AgendamentoService;
import com.senac.backend.pi.backend_projeto_integrador.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/agendamento")
public class AgendamentoController {
    @Autowired
    private AgendamentoService service;


    @PostMapping
    public ResponseEntity<Agendamento> create (@RequestBody Agendamento agendamento){

        if(agendamento != null){
            agendamento = service.create(agendamento);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(agendamento.getId()).toUri();

            return ResponseEntity.created(uri).body(agendamento);
        }

        return ResponseEntity.badRequest().body(agendamento);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> findAll(){

        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agendamento> findById(@PathVariable Integer id){
        Agendamento agendamento = service.findById(id);

        if(agendamento == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(agendamento);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Agendamento> update (@PathVariable Integer id, @RequestBody Agendamento agendamento)
    {
        if(agendamento == null) return ResponseEntity.badRequest().build();

        if(!service.existsInDatabase(id)) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(service.update(agendamento, id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        if(!service.existsInDatabase(id)) return ResponseEntity.notFound().build();

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
