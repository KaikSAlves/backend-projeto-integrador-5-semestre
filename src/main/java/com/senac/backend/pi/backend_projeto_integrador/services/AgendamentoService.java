package com.senac.backend.pi.backend_projeto_integrador.services;

import com.senac.backend.pi.backend_projeto_integrador.model.Agendamento;
import com.senac.backend.pi.backend_projeto_integrador.model.Animal;
import com.senac.backend.pi.backend_projeto_integrador.repository.AgendamentoRepository;
import com.senac.backend.pi.backend_projeto_integrador.services.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService implements ICrudService<Agendamento> {

    @Autowired
    private AgendamentoRepository rep;

    @Override
    public Agendamento create(Agendamento agendamento) {

        if(agendamento == null) return agendamento;

        return rep.save(agendamento);

    }

    @Override
    public List<Agendamento> findAll() {
        return rep.findAll();
    }

    @Override
    public Agendamento findById(Integer id) {
        return rep.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        if(rep.existsById(id)) rep.deleteById(id);
    }

    @Override
    public Agendamento update(Agendamento agendamento, Integer id) {
        try{
            Agendamento ent = rep.getReferenceById(id);
            updateData(ent, agendamento);
            return rep.save(ent);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateData(Agendamento ent, Agendamento agendamento) {
        ent.setDataFinal(agendamento.getDataFinal());
        ent.setDataInicio(agendamento.getDataInicio());
        ent.setFinalizado(agendamento.getFinalizado());
        ent.setValorFinal(agendamento.getValorFinal());
        ent.setServico(agendamento.getServico());
        ent.setAnimais(agendamento.getAnimais());
        ent.setCliente(agendamento.getCliente());
    }

    @Override
    public boolean existsInDatabase(Integer id) {
        return rep.existsById(id);
    }
}
