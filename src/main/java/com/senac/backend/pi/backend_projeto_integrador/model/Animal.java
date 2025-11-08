package com.senac.backend.pi.backend_projeto_integrador.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "raca", nullable = false, length = 100)
    private String raca;

    @Column(name = "idade", nullable = false)
    private Date dataNascimento;

    @Column(name = "especie", nullable = false, length = 100)
    private String especie;

    @ManyToOne
    @JoinColumn(name = "agendamento_id")
    private Agendamento agendamento;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Animal(String nome, String raca, int idade, String especie, Date dataNascimento) {
        this.nome = nome;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.especie = especie;
    }

    public Animal() {

    }

}
