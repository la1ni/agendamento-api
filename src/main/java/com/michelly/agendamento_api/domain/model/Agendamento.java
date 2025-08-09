package com.michelly.agendamento_api.domain.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "agendamento")
public class Agendamento {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Agendamento(UUID id, Usuario usuario, Servico servico, Profissional profissional, LocalDateTime data) {
        this.id = id;
        this.usuario = usuario;
        this.servico = servico;
        this.profissional = profissional;
        this.data = data;
    }

    public Agendamento(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
