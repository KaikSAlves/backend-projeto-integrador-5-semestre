package com.senac.backend.pi.backend_projeto_integrador.model;

import com.senac.backend.pi.backend_projeto_integrador.model.enums.Servicos;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "angendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Servicos servico;

    private Cliente cliente;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFinal;

    private boolean finalizado;

    private double valorFinal;

    public Integer getId() {
        return id;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Agendamento(Servicos servico, Cliente cliente, LocalDateTime dataInicio, LocalDateTime dataFinal, boolean finalizado, double valorFinal) {
        this.servico = servico;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.finalizado = finalizado;
        this.valorFinal = valorFinal;
    }
}
