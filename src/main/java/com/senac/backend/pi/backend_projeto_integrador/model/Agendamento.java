package com.senac.backend.pi.backend_projeto_integrador.model;

import com.senac.backend.pi.backend_projeto_integrador.model.enums.Servicos;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Servicos servico;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFinal;

    private boolean finalizado;

    private double valorFinal;

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public Integer getId() {
        return id;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
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

    public boolean getFinalizado() {
        return this.finalizado;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Agendamento(Servicos servico, LocalDateTime dataInicio, LocalDateTime dataFinal, boolean finalizado, double valorFinal) {
        this.servico = servico;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.finalizado = finalizado;
        this.valorFinal = valorFinal;
    }

    public Agendamento() {
    }
}
