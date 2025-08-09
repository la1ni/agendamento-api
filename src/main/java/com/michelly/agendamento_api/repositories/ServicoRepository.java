package com.michelly.agendamento_api.repositories;

import com.michelly.agendamento_api.domain.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoRepository extends JpaRepository<Servico, UUID> {
}
