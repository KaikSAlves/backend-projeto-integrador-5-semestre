package com.senac.backend.pi.backend_projeto_integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "funcionario")
public class Funcionario extends EntidadeBase {
    
    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 350, unique = true)
    private String email;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    public Funcionario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Funcionario(){
    }

}
