package com.michelly.agendamento_api.repositories;

import com.michelly.agendamento_api.domain.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {
}
