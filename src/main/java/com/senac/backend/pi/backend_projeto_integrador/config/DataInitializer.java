package com.senac.backend.pi.backend_projeto_integrador.config;

import com.senac.backend.pi.backend_projeto_integrador.model.Servico;
import com.senac.backend.pi.backend_projeto_integrador.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
@Profile("!test") // Não executa em testes
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existem serviços cadastrados
        if (servicoRepository.count() == 0) {
            // Cria os serviços iniciais
            Servico banho = new Servico(
                null,
                "Banho",
                "Banho completo com produtos de alta qualidade",
                new BigDecimal("50.00"),
                60, // 1 hora de duração
                true
            );

            Servico tosa = new Servico(
                null,
                "Tosa",
                "Tosa completa de acordo com a raça do animal",
                new BigDecimal("70.00"),
                90, // 1h30 de duração
                true
            );

            Servico banhoETosa = new Servico(
                null,
                "Banho e Tosa",
                "Pacote completo com banho e tosa",
                new BigDecimal("100.00"),
                120, // 2 horas de duração
                true
            );

            // Salva os serviços no banco de dados
            servicoRepository.saveAll(Arrays.asList(banho, tosa, banhoETosa));
            
            System.out.println("Serviços iniciais cadastrados com sucesso!");
        }
    }
}
