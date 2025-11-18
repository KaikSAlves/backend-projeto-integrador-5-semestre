package com.senac.backend.pi.backend_projeto_integrador.controller;

import com.senac.backend.pi.backend_projeto_integrador.model.Servico;
import com.senac.backend.pi.backend_projeto_integrador.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos() {
        List<Servico> servicos = service.findAll();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarServicoPorId(@PathVariable Integer id) {
        Servico servico = service.findById(id);
        if (servico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servico);
    }

    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody Servico servico) {
        if (servico == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Servico novoServico = service.create(servico);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoServico.getId())
                .toUri();
                
        return ResponseEntity.created(uri).body(novoServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizarServico(
            @PathVariable Integer id,
            @RequestBody Servico servico) {
        
        if (servico == null || !service.existsInDatabase(id)) {
            return ResponseEntity.notFound().build();
        }
        
        servico.setId(id);
        Servico servicoAtualizado = service.update(servico, id);
        
        return ResponseEntity.ok(servicoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirServico(@PathVariable Integer id) {
        if (!service.existsInDatabase(id)) {
            return ResponseEntity.notFound().build();
        }
        
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
