package com.senac.backend.pi.backend_projeto_integrador.services;

import com.senac.backend.pi.backend_projeto_integrador.model.Animal;
import com.senac.backend.pi.backend_projeto_integrador.model.Cliente;
import com.senac.backend.pi.backend_projeto_integrador.repository.AnimalRepository;
import com.senac.backend.pi.backend_projeto_integrador.services.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService implements ICrudService<Animal> {

    @Autowired
    private AnimalRepository rep;


    @Override
    public Animal create(Animal animal) {

        if(animal == null) return animal;

        return rep.save(animal);
    }

    @Override
    public List<Animal> findAll() {
        return rep.findAll();
    }

    @Override
    public Animal findById(Integer id) {
        return rep.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {

        if(rep.existsById(id)) rep.deleteById(id);
    }

    @Override
    public Animal update(Animal animal, Integer id) {

        try{
            Animal ent = rep.getReferenceById(id);
            updateData(ent, animal);
            return rep.save(ent);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsInDatabase(Integer id) {
        return rep.existsById(id);
    }

    public void updateData(Animal ent, Animal obj) {
        ent.setCliente(obj.getCliente());
        ent.setIdade(obj.getIdade());
        ent.setRaca(obj.getRaca());
        ent.setEspecie(obj.getEspecie());
        ent.setNome(obj.getNome());
    }
}
