package com.senac.backend.pi.backend_projeto_integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "animal")
public class Animal {

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "raca", nullable = false, length = 100)
    private String raca;

    @Column(name = "idade", nullable = false)
    private int idade;

    @Column(name = "especie", nullable = false, length = 100)
    private String especie;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Animal(String nome, String raca, int idade, String especie) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.especie = especie;
    }

    public Animal() {

    }

}
