package com.michelly.agendamento_api.dtos.out;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

public record ResponseDadosServicoDto(UUID id, String nome, BigDecimal valor, Duration duracao) {
}
