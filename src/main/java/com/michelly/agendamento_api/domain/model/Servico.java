package com.michelly.agendamento_api.domain.model;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;


@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column(nullable = false)
    private Duration duracao;

    public Servico(String nome, BigDecimal valor, Duration duracao) {
        this.nome = nome;
        this.valor = valor;
        this.duracao = duracao;
    }

    public Servico() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }
}
