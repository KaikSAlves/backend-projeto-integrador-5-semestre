package com.senac.backend.pi.backend_projeto_integrador.config;

import com.senac.backend.pi.backend_projeto_integrador.model.Animal;
import com.senac.backend.pi.backend_projeto_integrador.model.Cliente;
import com.senac.backend.pi.backend_projeto_integrador.model.Usuario;
import com.senac.backend.pi.backend_projeto_integrador.repository.AnimalRepository;
import com.senac.backend.pi.backend_projeto_integrador.repository.ClienteRespository;
import com.senac.backend.pi.backend_projeto_integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public void run(String... args) throws Exception {

        Cliente cliente = clienteRespository.save(new Cliente("kaik", "kaik@gmail.com", "kaik",""));

        animalRepository.save(new Animal("kaik", "", "asd", new Date(), cliente));


    }
    
}
