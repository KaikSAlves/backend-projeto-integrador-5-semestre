package com.senac.backend.pi.backend_projeto_integrador.controller;

import com.senac.backend.pi.backend_projeto_integrador.model.Animal;
import com.senac.backend.pi.backend_projeto_integrador.model.Cliente;
import com.senac.backend.pi.backend_projeto_integrador.services.AnimalService;
import com.senac.backend.pi.backend_projeto_integrador.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/animal")
public class AnimalController {
    @Autowired
    private AnimalService service;


    @PostMapping
    public ResponseEntity<Animal> create (@RequestBody Animal animal){

        if(animal != null){
            animal = service.create(animal);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(animal.getId()).toUri();

            return ResponseEntity.created(uri).body(animal);
        }

        return ResponseEntity.badRequest().body(animal);
    }

    @GetMapping
    public ResponseEntity<List<Animal>> findAll(){

        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Integer id){
        Animal animal = service.findById(id);

        if(animal == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(animal);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Animal>> findByClienteId(@PathVariable Integer clienteId) {
        List<Animal> animais = service.findByClienteId(clienteId);
        return ResponseEntity.ok().body(animais);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Animal> update (@PathVariable Integer id, @RequestBody Animal animal)
    {
        if(animal == null) return ResponseEntity.badRequest().build();

        if(!service.existsInDatabase(id)) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(service.update(animal, id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){

        if(!service.existsInDatabase(id)) return ResponseEntity.notFound().build();

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
