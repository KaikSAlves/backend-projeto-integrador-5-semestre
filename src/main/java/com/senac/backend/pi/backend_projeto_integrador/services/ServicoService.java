package com.senac.backend.pi.backend_projeto_integrador.services;

import com.senac.backend.pi.backend_projeto_integrador.model.Servico;
import com.senac.backend.pi.backend_projeto_integrador.repository.ServicoRepository;
import com.senac.backend.pi.backend_projeto_integrador.services.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService implements ICrudService<Servico> {

    @Autowired
    private ServicoRepository repository;

    @Override
    public Servico create(Servico servico) {
        if (servico == null) return null;
        return repository.save(servico);
    }

    @Override
    public List<Servico> findAll() {
        return repository.findByAtivoTrue();
    }

    @Override
    public Servico findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        Optional<Servico> servicoOpt = repository.findById(id);
        servicoOpt.ifPresent(servico -> {
            servico.setAtivo(false);
            repository.save(servico);
        });
    }

    @Override
    public Servico update(Servico servico, Integer id) {
        if (servico == null) return null;
        
        return repository.findById(id)
                .map(existingServico -> {
                    existingServico.setNome(servico.getNome());
                    existingServico.setDescricao(servico.getDescricao());
                    existingServico.setValor(servico.getValor());
                    existingServico.setDuracaoMinutos(servico.getDuracaoMinutos());
                    return repository.save(existingServico);
                })
                .orElse(null);
    }

    @Override
    public boolean existsInDatabase(Integer id) {
        return repository.existsById(id) && 
               repository.findById(id)
                       .map(Servico::isAtivo)
                       .orElse(false);
    }
}
