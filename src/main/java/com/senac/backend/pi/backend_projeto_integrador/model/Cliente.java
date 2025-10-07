package com.senac.backend.pi.backend_projeto_integrador.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 350, unique = true)
    private String email;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;
    
    @OneToMany(mappedBy = "cliente")
    private List<Animal> animais = new ArrayList<>();


    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente(){
    }

}
