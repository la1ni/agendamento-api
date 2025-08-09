package com.michelly.agendamento_api.domain.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profissional")
public class Profissional {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;
    @Column
    @OneToMany
    @JoinTable(name = "profissional_servico",
            joinColumns = @JoinColumn(name = "profissional(id)"), inverseJoinColumns = @JoinColumn(name = "servico(id)"))
    private List<Servico> servicos = new ArrayList<>();

    public Profissional(UUID id) {
    }

    public Profissional(String nome, String email, String telefone, List<Servico> servicos) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.servicos = servicos;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
